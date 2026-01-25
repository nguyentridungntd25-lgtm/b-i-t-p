CREATE TABLE order_detail (
    id SERIAL PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    unit_price NUMERIC
);

INSERT INTO order_detail (order_id, product_name, quantity, unit_price) VALUES
(1, 'Bút bi', 10, 5000),
(1, 'Vở ô ly', 5, 12000),
(1, 'Thước kẻ', 2, 8000),
(2, 'Chuột máy tính', 1, 250000),
(2, 'Bàn phím', 1, 350000);

CREATE OR REPLACE PROCEDURE calculate_order_total_no_coalesce(
    order_id_input INT,
    OUT total NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    SELECT SUM(quantity * unit_price)
    INTO total
    FROM order_detail
    WHERE order_id = order_id_input;

    IF total IS NULL THEN
        total := 0;
    END IF;
END;
$$;

CALL calculate_order_total(1, NULL);