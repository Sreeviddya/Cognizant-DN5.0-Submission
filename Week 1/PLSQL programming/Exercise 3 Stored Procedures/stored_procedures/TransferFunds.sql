-- Scenario 3: Transfer funds between two accounts with sufficient balance check

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN VARCHAR2,
    p_to_account   IN VARCHAR2,
    p_amount       IN NUMBER
) IS
    v_balance NUMBER;
    insufficient_balance EXCEPTION;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_number = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE insufficient_balance;
    END IF;

    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_number = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_number = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_amount ||
                         ' from ' || p_from_account ||
                         ' to '   || p_to_account || ' completed.');

EXCEPTION
    WHEN insufficient_balance THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in account ' || p_from_account);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/
