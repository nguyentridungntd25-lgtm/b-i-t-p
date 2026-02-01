CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(100),
    stock INT,
    price NUMERIC(10,2)
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(100),
    total_amount NUMERIC(10,2),
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE order_items (
    order_item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(order_id),
    product_id INT REFERENCES products(product_id),
    quantity INT,
    subtotal NUMERIC(10,2)
);

INSERT INTO products (product_name, stock, price)
VALUES
    ('Product 1', 5, 100.00),
    ('Product 2', 3, 200.00);

BEGIN;

INSERT INTO orders (customer_name, total_amount)
VALUES ('Nguyen Van A', 0)
RETURNING order_id;

-- giả sử order_id = 1

UPDATE products
SET stock = stock - 2
WHERE product_id = 1 AND stock >= 2;

UPDATE products
SET stock = stock - 1
WHERE product_id = 2 AND stock >= 1;

INSERT INTO order_items (order_id, product_id, quantity, subtotal)
VALUES
    (1, 1, 2, 2 * (SELECT price FROM products WHERE product_id = 1)),
    (1, 2, 1, 1 * (SELECT price FROM products WHERE product_id = 2));

UPDATE orders
SET total_amount = (
    SELECT SUM(subtotal)
    FROM order_items
    WHERE order_id = 1
)
WHERE order_id = 1;

COMMIT;

SELECT * FROM products;
SELECT * FROM orders;
SELECT * FROM order_items;

UPDATE products SET stock = 0 WHERE product_id = 1;

BEGIN;

INSERT INTO orders (customer_name, total_amount)
VALUES ('Nguyen Van A', 0)
RETURNING order_id;

-- giả sử order_id = 2

UPDATE products
SET stock = stock - 2
WHERE product_id = 1 AND stock >= 2;

UPDATE products
SET stock = stock - 1
WHERE product_id = 2 AND stock >= 1;

ROLLBACK;

SELECT * FROM products;
SELECT * FROM orders;
SELECT * FROM order_items;