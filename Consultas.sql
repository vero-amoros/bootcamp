-- Obtener todos los actores de nombre ‘NICK’.
SELECT * FROM actor WHERE actor.first_name = 'Nick'

-- Obtener una lista con todos los distritos distintos (district en address).
SELECT DISTINCT district FROM address ORDER BY district ASC

-- Obtener las películas sobre agentes secretos (description contiene ‘Secret Agent’).
SELECT * FROM film f WHERE f.description LIKE "%Secret Agent%"

-- Mostrar la lista de las películas mas caras (coste por minuto)
SELECT title, rental_rate/LENGTH AS precioPorMinuto  FROM film f ORDER BY precioPorMinuto DESC

-- Obtener los códigos y medias de gasto de los clientes que han gastado mas de 100 en menos de 25 operaciones.
SELECT customer_id, AVG(amount) FROM payment p GROUP BY customer_id HAVING SUM(p.amount)>100 AND COUNT(customer_id)<25

-- Obtener los 5 nombres de actor más repetidos (aprox).
SELECT first_name, count(first_name) as total FROM actor GROUP BY first_name ORDER BY total DESC LIMIT 5

-- Para felicitar el año nuevo chino se necesita el listado con los datos postales de los clientes residentes en China y Taiwan
SELECT postal_code, co.country
FROM address a, city c, customer cu, country co
WHERE a.city_id = c.city_id 
AND a.address_id = cu.address_id
AND co.country_id = c.country_id 
HAVING co.country = 'CHINA' OR co.country = 'TAIWAN'

-- Mostrar los datos de las tiendas, conocidas por la ciudad y país donde están ubicadas, indicando el nombre del gerente, el numero de películas en inventario, el numero de títulos diferentes y el número de clientes atendidos.
SELECT CONCAT(st.first_name, " ", st.last_name) 'gerente', c.city, co.country, a.address, `num pelis`, `titulos distintos`,`clientes`
FROM store s
INNER JOIN address a ON s.address_id = a.address_id
INNER JOIN city c ON c.city_id = a.city_id
INNER JOIN country co ON c.country_id = co.country_id
INNER JOIN staff st ON s.manager_staff_id = st.staff_id,
(SELECT COUNT(i.film_id) `num pelis`, COUNT(DISTINCT film_id) AS `titulos distintos` FROM inventory i, store s WHERE i.store_id = s.store_id GROUP BY i.store_id) AS P,
(SELECT COUNT(DISTINCT cu.customer_id) `clientes`, store_id FROM customer cu GROUP BY store_id) AS C


-- Obtener el listado detallado de alquileres indicando el identificador de alquiler, el titulo alquilado, las fechas de alquiler, devolución y tiempo transcurrido, nombres del cliente (nombre con apellidos), empleado (nombre con apellidos) y tienda (ciudad, país).
SELECT r.rental_id 'Alquiler ID' , f.title 'Título', r.rental_date 'Fecha de alquiler', r.return_date 'Fecha de devolución', 
DATEDIFF(r.return_date, r.rental_date) 'Tiempo transcurrido', CONCAT(cu.first_name, " ", cu.last_name) 'Cliente', CONCAT(st.first_name, " ", st.last_name) 'Empleado', CONCAT(c.city, " (", co.country, ")") 'Localización tienda'
FROM rental r
INNER JOIN inventory i ON r.inventory_id = i.inventory_id
INNER JOIN film f ON f.film_id = i.film_id
INNER JOIN customer cu ON cu.customer_id = r.customer_id
INNER JOIN staff st ON st.staff_id = r.staff_id
INNER JOIN address a ON a.address_id = cu.address_id
INNER JOIN city c ON c.city_id = a.city_id
INNER JOIN country co ON co.country_id = c.country_id;

-- Generar la lista diaria de alquileres vencidos no devueltos para poder llamar a los clientes y pedirles que los devuelvan, para ello debe mostrar las fechas de alquiler y vencimiento, el teléfono y nombre del cliente, así como el titulo de la película, priorizando los que mas tiempo llevan vencidos.
SELECT r.rental_id 'Alquiler ID', r.rental_date 'Fecha de alquiler', r.return_date 'Fecha de devolución', CONCAT(cu.first_name, " ", cu.last_name) 'Cliente', a.phone 'Teléfono', f.title 'Título', DATEDIFF(CURRENT_DATE, r.rental_date) AS tiempoAlquilado
FROM rental r
INNER JOIN staff st ON r.staff_id = st.staff_id 
INNER JOIN address a ON a.address_id = st.address_id
INNER JOIN city c ON c.city_id = a.city_id
INNER JOIN country co ON c.country_id = co.country_id
INNER JOIN inventory i ON i.inventory_id = r.inventory_id
INNER JOIN film f ON f.film_id = i.film_id
INNER JOIN customer cu ON cu.customer_id = r.customer_id
GROUP BY r.rental_id
HAVING r.return_date IS NULL 
ORDER BY tiempoAlquilado DESC, cu.first_name 

-- Elaborar el ranking de los países que más alquilan las películas de GINA DEGENERES.
SELECT RANK () over(ORDER BY COUNT(r.rental_id)  DESC) AS Ranking, ac.actor_id, ac.first_name, ac.last_name, co.country 'País', 
COUNT(r.rental_id) 'Número de alquileres'
FROM rental r
INNER JOIN inventory i ON r.inventory_id = i.inventory_id
INNER JOIN film f ON f.film_id = i.film_id
INNER JOIN film_actor fa ON f.film_id = fa.film_id
INNER JOIN actor ac ON ac.actor_id = fa.actor_id
INNER JOIN customer cu ON cu.customer_id = r.customer_id
INNER JOIN address a ON a.address_id = cu.address_id
INNER JOIN city c ON c.city_id = a.city_id
INNER JOIN country co ON c.country_id = co.country_id
GROUP BY ac.actor_id, co.country_id
HAVING ac.first_name = 'GINA' AND ac.last_name = 'DEGENERES'	