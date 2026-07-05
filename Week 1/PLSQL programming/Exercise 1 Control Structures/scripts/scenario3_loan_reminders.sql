-- Scenario 3: Print reminder messages for loans due within the next 30 days

BEGIN
    FOR loan_rec IN (
        SELECT c.name, l.loan_id, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || loan_rec.name ||
            ', Loan #' || loan_rec.loan_id ||
            ' is due on ' || TO_CHAR(loan_rec.due_date, 'YYYY-MM-DD') || '.'
        );
    END LOOP;
END;
/
