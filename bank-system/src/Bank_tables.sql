CREATE TABLE IF NOT EXISTS banks(
    bank_id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (bank_id)
);

CREATE TABLE IF NOT EXISTS bank_branches(
    bank_branch_id INT GENERATED ALWAYS AS IDENTITY,
    address VARCHAR(255) NOT NULL,
    bank_id INT,
    PRIMARY KEY(bank_branch_id),
    CONSTRAINT fk_bank
        FOREIGN KEY (bank_id)
        REFERENCES banks(bank_id)
        ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS clients(
    client_id INT GENERATED ALWAYS AS IDENTITY,
    bank_branch_id INT,
    password VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    dni VARCHAR(10) NOT NULL,
    gender VARCHAR(9) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY(client_id),
    CONSTRAINT fk_bank_branch
        FOREIGN KEY(bank_branch_id)
        REFERENCES bank_branches(bank_branch_id)
        ON DELETE SET NULL
);


CREATE TABLE IF NOT EXISTS accounts(
    account_id INT GENERATED ALWAYS AS IDENTITY,
    bank_id INT,
    client_id INT,
    cbu VARCHAR(255) NOT NULL,
    balance DOUBLE PRECISION NOT NULL,
    type_account VARCHAR(255) NOT NULL,
    PRIMARY KEY(account_id),
    CONSTRAINT fk_bank
        FOREIGN KEY (bank_id)
        REFERENCES banks(bank_id)
        ON DELETE SET NULL,
    CONSTRAINT fk_client
        FOREIGN KEY(client_id)
        REFERENCES clients(client_id)
        ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS charges(
    charge_id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255),
    salary DOUBLE PRECISION,
    PRIMARY KEY(charge_id)
);

CREATE TABLE IF NOT EXISTS employees(
    employee_id INT GENERATED ALWAYS AS IDENTITY,
    charge_id INT,
    bank_branch_id INT,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    dni VARCHAR(10) NOT NULL,
    gender VARCHAR(9) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    email VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY(employee_id),
    CONSTRAINT fk_bank_branch
        FOREIGN KEY(bank_branch_id)
        REFERENCES bank_branches(bank_branch_id)
        ON DELETE SET NULL,
    CONSTRAINT fk_charge
        FOREIGN KEY(charge_id)
        REFERENCES charges(charge_id)
        ON DELETE SET NULL
);
