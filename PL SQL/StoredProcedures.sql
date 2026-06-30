-- Program 1: Greeting Procedure

CREATE OR REPLACE PROCEDURE greet_user
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Welcome to PL/SQL');
END;
/

BEGIN
    greet_user;
END;
/

-- Program 2: Addition Procedure

CREATE OR REPLACE PROCEDURE add_numbers(
    a NUMBER,
    b NUMBER
)
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Sum = ' || (a + b));
END;
/

BEGIN
    add_numbers(10,20);
END;
/

-- Program 3: Employee Details Procedure

CREATE OR REPLACE PROCEDURE employee_details
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee ID : 101');
    DBMS_OUTPUT.PUT_LINE('Employee Name : Rahul');
    DBMS_OUTPUT.PUT_LINE('Department : IT');
END;
/

BEGIN
    employee_details;
END;
/