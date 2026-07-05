-- Scenario 1: Process monthly interest for all savings accounts (1%)

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE savings_accounts
    SET balance = balance * 1.01;
    COMMIT;
END ProcessMonthlyInterest;
/
