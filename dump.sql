;             
CREATE USER IF NOT EXISTS "SA" SALT '3df89ac4c5b1d457' HASH '954acb9e9a707875a96005dfd192e8cb24b6f8fc1b1a67773d62a304b6765cdd' ADMIN;         
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_61FC5E74_E4EF_4421_AE24_9D94CEBE799E" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9152A997_B599_4911_9BF5_ECF263D128CA" START WITH 4 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_EDCC04C3_A428_4DFA_87D1_6CC07F6AD9DD" START WITH 5 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."PROFESSORES"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_9152A997_B599_4911_9BF5_ECF263D128CA" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9152A997_B599_4911_9BF5_ECF263D128CA",
    "NOME" VARCHAR(255),
    "CPF" VARCHAR(255),
    "RUA" VARCHAR(255),
    "CEP" VARCHAR(255),
    "NUMERO" INT
);
ALTER TABLE "PUBLIC"."PROFESSORES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");  
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.PROFESSORES;             
INSERT INTO "PUBLIC"."PROFESSORES" VALUES
(0, 'Jose', '12345678900', 'Rua D', '0557020', 11),
(1, 'Rachel', '123456789787', 'Rua X', '02115454', 3),
(2, 'Maria', '7896542125', 'Rua Y', '12548', 5);      
CREATE CACHED TABLE "PUBLIC"."USUARIOS"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_EDCC04C3_A428_4DFA_87D1_6CC07F6AD9DD" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_EDCC04C3_A428_4DFA_87D1_6CC07F6AD9DD",
    "NOME" VARCHAR(255),
    "EMAIL" VARCHAR(255)
);      
ALTER TABLE "PUBLIC"."USUARIOS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");     
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.USUARIOS;
INSERT INTO "PUBLIC"."USUARIOS" VALUES
(0, 'user', 'user@gmail.com'),
(1, 'Rachel', 'rachelaraujo17@gmail.com'),
(2, 'user', 'user@gmail.com');            
CREATE CACHED TABLE "PUBLIC"."VENDAS"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_61FC5E74_E4EF_4421_AE24_9D94CEBE799E" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_61FC5E74_E4EF_4421_AE24_9D94CEBE799E",
    "VALOR_TOTAL" NUMERIC(5, 2),
    "USUARIO_ID" INT
);    
ALTER TABLE "PUBLIC"."VENDAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("ID");       
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.VENDAS;  
ALTER TABLE "PUBLIC"."VENDAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_96" FOREIGN KEY("USUARIO_ID") REFERENCES "PUBLIC"."USUARIOS"("ID") NOCHECK; 
