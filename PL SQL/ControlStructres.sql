--Program 1:even or odd using if
DECLARE
    num NUMBER := 10;
BEGIN
    IF MOD(num,2)=0 THEN
        DBMS_OUTPUT.PUT_LINE('Even Number');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Odd Number');
    END IF;
END;
/

--Program 2:largest of three numbers
DECLARE
    a NUMBER := 20;
    b NUMBER := 15;
    c NUMBER := 30;
BEGIN
    IF a>b AND a>c THEN
        DBMS_OUTPUT.PUT_LINE('Largest = '||a);
    ELSIF b>a AND b>c THEN
        DBMS_OUTPUT.PUT_LINE('Largest = '||b);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Largest = '||c);
    END IF;
END;
/

--Program 3:FOR loop
BEGIN
    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;
END;
/

--Program 4:While loop
DECLARE
    i NUMBER:=1;
BEGIN
    WHILE i<=5 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
        i:=i+1;
    END LOOP;
END;
/

--Program 5:CASE statement
DECLARE
    grade CHAR:='A';
BEGIN
    CASE grade
        WHEN 'A' THEN
            DBMS_OUTPUT.PUT_LINE('Excellent');
        WHEN 'B' THEN
            DBMS_OUTPUT.PUT_LINE('Good');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Average');
    END CASE;
END;
/