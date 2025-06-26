DECLARE
  v_due_date   DATE := SYSDATE + 30;
BEGIN
  FOR loan IN (
    SELECT l.LoanID, c.CustomerID, c.CustomerName, l.DueDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.DueDate BETWEEN SYSDATE AND v_due_date
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan.LoanID ||
                         ' for Customer ' || loan.CustomerName || 
                         ' is due on ' || TO_CHAR(loan.DueDate, 'DD-Mon-YYYY'));
  END LOOP;
END;
/
