SET SERVEROUTPUT ON;

-- Scenario 1: Apply 1% Discount for Senior Citizens (Age > 60 derived from DOB)
BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60
    ) LOOP
        UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest updated successfully.');
END;
/

-- Scenario 2: Promote Customers to VIP
ALTER TABLE Customers ADD IsVIP VARCHAR2(5);

BEGIN
    FOR rec IN (
        SELECT CustomerID FROM Customers WHERE Balance > 10000
    ) LOOP
        UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = rec.CustomerID;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP customers updated successfully.');
END;
/

-- Scenario 3: Loan Reminder (Due within 30 days)
BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name || ', your Loan ID ' || rec.LoanID || ' is due on ' || TO_CHAR(rec.EndDate,'DD-MON-YYYY'));
    END LOOP;
END;
/
