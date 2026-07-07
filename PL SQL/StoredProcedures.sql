SET SERVEROUTPUT ON;

-- Scenario 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts SET Balance = Balance + (Balance * 0.01) WHERE AccountType = 'Savings';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/

-- Scenario 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_Department IN VARCHAR2, p_BonusPercent IN NUMBER) IS
BEGIN
    UPDATE Employees SET Salary = Salary + (Salary * p_BonusPercent / 100) WHERE Department = p_Department;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/

-- Scenario 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds(p_FromAccount IN NUMBER, p_ToAccount IN NUMBER, p_Amount IN NUMBER) IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_FromAccount;
    
    IF v_Balance >= p_Amount THEN
        UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccount;
        UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccount;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');
    END IF;
END;
/
