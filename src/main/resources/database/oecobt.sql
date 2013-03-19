-- Sequence: seq_pic

-- DROP SEQUENCE seq_pic;

CREATE SEQUENCE seq_pic
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_pic
  OWNER TO oecobt;

-- Table: pic

-- DROP TABLE pic;

CREATE TABLE pic
(
  id integer NOT NULL DEFAULT nextval('seq_pic'::regclass),
  name character varying(255),
  CONSTRAINT pic_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pic
  OWNER TO oecobt;

-- Sequence: seq_status

-- DROP SEQUENCE seq_status;

CREATE SEQUENCE seq_status
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_status
  OWNER TO oecobt;

-- Table: pic

-- DROP TABLE pic;

CREATE TABLE status
(
  id integer NOT NULL DEFAULT nextval('seq_status'::regclass),
  name character varying(255),
  CONSTRAINT status_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE status
  OWNER TO oecobt;

-- Sequence: seq_severity

-- DROP SEQUENCE seq_severity;

CREATE SEQUENCE seq_severity
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_severity
  OWNER TO oecobt;

-- Table: severity

-- DROP TABLE severity;

CREATE TABLE severity
(
  id integer NOT NULL DEFAULT nextval('seq_severity'::regclass),
  name character varying(255),
  CONSTRAINT severity_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE severity
  OWNER TO oecobt;

-- Sequence: seq_priority

-- DROP SEQUENCE seq_priority;

CREATE SEQUENCE seq_priority
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_priority
  OWNER TO oecobt;

-- Table: priority

-- DROP TABLE priority;

CREATE TABLE priority
(
  id integer NOT NULL DEFAULT nextval('seq_priority'::regclass),
  name character varying(255),
  CONSTRAINT priority_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE priority
  OWNER TO oecobt;

-- Sequence: seq_defect

-- DROP SEQUENCE seq_defect;

CREATE SEQUENCE seq_defect
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_defect
  OWNER TO oecobt;

-- Table: defect

-- DROP TABLE defect;

CREATE TABLE defect
(
  id integer NOT NULL DEFAULT nextval('seq_defect'::regclass),
  description character varying(255),
  notes character varying(255),
  pic integer REFERENCES pic(id),
  status integer REFERENCES status(id),
  estimate double precision,
  severity integer REFERENCES severity(id),
  priority integer REFERENCES priority(id),
  CONSTRAINT defect_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE defect
  OWNER TO oecobt;

