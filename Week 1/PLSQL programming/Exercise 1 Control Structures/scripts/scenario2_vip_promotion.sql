-- Scenario 2: Set IsVIP flag to TRUE for customers with balance > $10,000

BEGIN
    FOR cust IN (SELECT customer_id, balance FROM customers) LOOP
        IF cust.balance > 10000 THEN
            UPDATE customers
            SET is_vip = 1
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
