CREATE TABLE inventory (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(100),
    quantity INT
);

INSERT INTO inventory (product_name, quantity) VALUES
('Laptop', 10),
('Chuột', 3),
('Bàn phím', 0);

CREATE OR REPLACE PROCEDURE check_stock(
    p_id INT,
    p_qty INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    stock_qty INT;
BEGIN
    SELECT quantity
    INTO stock_qty
    FROM inventory
    WHERE product_id = p_id;
    IF stock_qty IS NULL THEN
        RAISE EXCEPTION 'Sản phẩm không tồn tại';
    END IF;

    IF stock_qty < p_qty THEN
        RAISE EXCEPTION 'Không đủ hàng trong kho';
    END IF;

    RAISE NOTICE 'Đủ hàng để bán';
END;
$$;


CALL check_stock(1, 5);

CALL check_stock(2, 5);