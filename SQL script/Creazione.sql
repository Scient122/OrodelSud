Create schema OrodelSud;

Use OrodelSud;
CREATE TABLE amministratore (
  email varchar(30) NOT NULL,
  nome varchar(20) NOT NULL,
  cognome varchar(20) NOT NULL,
  via varchar(30) NOT NULL,
  cap varchar(10) NOT NULL,
  citta varchar(30) NOT NULL,
  n_civico varchar(5) NOT NULL,
  pass varchar(40) NOT NULL,
  data_nascita varchar(45) NOT NULL,
  n_telefono varchar(10) NOT NULL,
  PRIMARY KEY (email)
);

Use OrodelSud;
CREATE TABLE azienda (
  email varchar(30) NOT NULL,
  nome varchar(20) NOT NULL,
  via varchar(30) NOT NULL,
  cap varchar(10) NOT NULL,
  citta varchar(30) NOT NULL,
  n_civico varchar(5) NOT NULL,
  pass varchar(40) NOT NULL,
  numero_telefono varchar(10) NOT NULL,
  PRIMARY KEY (email)
);

Use OrodelSud;
CREATE TABLE carta_di_credito (
  tipologia varchar(20) DEFAULT NULL,
  numero varchar(20) NOT NULL,
  PRIMARY KEY (numero)
);

Use OrodelSud;
CREATE TABLE cliente (
  email varchar(30) NOT NULL,
  nome varchar(20) NOT NULL,
  cognome varchar(20) NOT NULL,
  via varchar(30) NOT NULL,
  cap varchar(10) NOT NULL,
  citta varchar(30) NOT NULL,
  n_civico varchar(5) NOT NULL,
  pass varchar(40) NOT NULL,
  n_punti int(11) DEFAULT '0',
  data_nascita date NOT NULL,
  n_telefono varchar(15) DEFAULT NULL,
  PRIMARY KEY (email)
);

Use OrodelSud;
CREATE TABLE prodotto (
  codice varchar(10) NOT NULL,
  nome_prodotto varchar(20) NOT NULL,
  descrizione varchar(1000) NOT NULL,
  iva int(11) NOT NULL,
  prezzo_base double NOT NULL,
  quantita_disponibili int(11) NOT NULL,
  offerta tinyint(1) DEFAULT '0',
  prezzo_totale double NOT NULL,
  conservazione varchar(10) NOT NULL,
  categoria varchar(20) NOT NULL,
  immagine longblob,
  azienda varchar(45) DEFAULT NULL,
  PRIMARY KEY (codice),
  UNIQUE KEY nome_prodotto (nome_prodotto)
);

Use OrodelSud;
CREATE TABLE fattura (
  n_documento varchar(30) NOT NULL,
  data_fattura date NOT NULL,
  destinatario varchar(30) NOT NULL,
  totale_imponibile double NOT NULL,
  totale_imposta double NOT NULL,
  costo_totale double NOT NULL,
  status varchar(45) NOT NULL,
  via varchar(45) NOT NULL,
  PRIMARY KEY (n_documento)
);

Use OrodelSud;
CREATE TABLE composizione (
  codice_prodotto varchar(10) NOT NULL,
  numero_fattura varchar(30) NOT NULL,
  quantita_acquistate int(11) NOT NULL,
  iva_acquisto int(11) NOT NULL,
  prezzo_acquisto double NOT NULL,
  data_acquisto date NOT NULL,
  nome_prodotto varchar(45) NOT NULL,
  PRIMARY KEY (numero_fattura,codice_prodotto),
  KEY codice_prodotto (codice_prodotto),
  CONSTRAINT composizione_ibfk_1 FOREIGN KEY (codice_prodotto) REFERENCES prodotto (codice),
  CONSTRAINT composizione_ibfk_2 FOREIGN KEY (numero_fattura) REFERENCES fattura (n_documento) ON DELETE CASCADE
);

Use OrodelSud;
CREATE TABLE effettuazione (
  email_cliente varchar(30) NOT NULL,
  numero_documento varchar(30) NOT NULL,
  PRIMARY KEY (numero_documento),
  KEY email_cliente (email_cliente),
  CONSTRAINT effettuazione_ibfk_1 FOREIGN KEY (email_cliente) REFERENCES cliente (email) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT effettuazione_ibfk_2 FOREIGN KEY (numero_documento) REFERENCES fattura (n_documento) ON DELETE CASCADE
);

Use OrodelSud;
CREATE TABLE possesso (
  proprietario varchar(30) NOT NULL,
  numero_carta varchar(20) NOT NULL,
  PRIMARY KEY (numero_carta),
  KEY proprietario (proprietario),
  CONSTRAINT possesso_ibfk_1 FOREIGN KEY (proprietario) REFERENCES cliente (email) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT possesso_ibfk_2 FOREIGN KEY (numero_carta) REFERENCES carta_di_credito (numero) ON DELETE CASCADE ON UPDATE CASCADE
);

Use OrodelSud;
CREATE TABLE recensione (
  email_cliente varchar(30) NOT NULL,
  titolo_ricetta varchar(50) NOT NULL,
  commento varchar(1000) NOT NULL,
  id int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

Use OrodelSud;
CREATE TABLE ricetta (
  titolo varchar(50) NOT NULL,
  descrizione varchar(10000) NOT NULL,
  categoria varchar(20) NOT NULL,
  provenienza varchar(20) NOT NULL,
  immagine longblob,
  PRIMARY KEY (titolo)
);