USE safebank_ledger;

INSERT INTO bank_accounts
(account_number, account_holder_name, email, currency, balance, status, created_at)
VALUES
('SB-100001', 'Chris Miller', 'chris.miller@example.com', 'CAD', 3250.75, 'ACTIVE', NOW(6)),
('SB-100002', 'Maya Johnson', 'maya.johnson@example.com', 'CAD', 8120.00, 'ACTIVE', NOW(6)),
('SB-100003', 'Noah Williams', 'noah.williams@example.com', 'CAD', 560.25, 'ACTIVE', NOW(6)),
('SB-100004', 'Emma Anderson', 'emma.anderson@example.com', 'CAD', 12450.90, 'ACTIVE', NOW(6)),
('SB-100005', 'Liam Brown', 'liam.brown@example.com', 'CAD', 0.00, 'CLOSED', NOW(6));

INSERT INTO ledger_entries
(account_number, type, amount, resulting_balance, related_account_number, description, created_at)
VALUES
('SB-100001', 'DEPOSIT', 3000.00, 3000.00, NULL, 'Opening deposit', NOW(6)),
('SB-100001', 'DEPOSIT', 500.00, 3500.00, NULL, 'Payroll deposit', NOW(6)),
('SB-100001', 'WITHDRAWAL', 249.25, 3250.75, NULL, 'ATM withdrawal', NOW(6)),

('SB-100002', 'DEPOSIT', 8000.00, 8000.00, NULL, 'Opening deposit', NOW(6)),
('SB-100002', 'DEPOSIT', 320.00, 8320.00, NULL, 'Refund deposit', NOW(6)),
('SB-100002', 'WITHDRAWAL', 200.00, 8120.00, NULL, 'Bill payment', NOW(6)),

('SB-100003', 'DEPOSIT', 900.00, 900.00, NULL, 'Opening deposit', NOW(6)),
('SB-100003', 'WITHDRAWAL', 339.75, 560.25, NULL, 'Groceries and cash withdrawal', NOW(6)),

('SB-100004', 'DEPOSIT', 12000.00, 12000.00, NULL, 'Opening deposit', NOW(6)),
('SB-100004', 'DEPOSIT', 450.90, 12450.90, NULL, 'Interest and adjustment', NOW(6)),

('SB-100005', 'DEPOSIT', 1000.00, 1000.00, NULL, 'Opening deposit', NOW(6)),
('SB-100005', 'WITHDRAWAL', 1000.00, 0.00, NULL, 'Account closure withdrawal', NOW(6)),

('SB-100001', 'TRANSFER_OUT', 100.00, 3150.75, 'SB-100003', 'Transfer to Noah Williams', NOW(6)),
('SB-100003', 'TRANSFER_IN', 100.00, 660.25, 'SB-100001', 'Transfer from Chris Miller', NOW(6));
