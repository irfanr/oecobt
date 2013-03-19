--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.6
-- Dumped by pg_dump version 9.1.6
-- Started on 2013-03-19 15:52:29 WIT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 176 (class 3079 OID 11680)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1954 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 167 (class 1259 OID 184269)
-- Dependencies: 6
-- Name: defect; Type: TABLE; Schema: public; Owner: oecobt; Tablespace: 
--

CREATE TABLE defect (
    id integer NOT NULL,
    description character varying(255),
    estimate double precision,
    notes character varying(255),
    pic integer,
    priority integer,
    severity integer,
    status integer
);


ALTER TABLE public.defect OWNER TO oecobt;

--
-- TOC entry 166 (class 1259 OID 184267)
-- Dependencies: 6 167
-- Name: defect_id_seq; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE defect_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.defect_id_seq OWNER TO oecobt;

--
-- TOC entry 1955 (class 0 OID 0)
-- Dependencies: 166
-- Name: defect_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oecobt
--

ALTER SEQUENCE defect_id_seq OWNED BY defect.id;


--
-- TOC entry 1956 (class 0 OID 0)
-- Dependencies: 166
-- Name: defect_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('defect_id_seq', 3, true);


--
-- TOC entry 169 (class 1259 OID 184280)
-- Dependencies: 6
-- Name: pic; Type: TABLE; Schema: public; Owner: oecobt; Tablespace: 
--

CREATE TABLE pic (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.pic OWNER TO oecobt;

--
-- TOC entry 168 (class 1259 OID 184278)
-- Dependencies: 6 169
-- Name: pic_id_seq; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE pic_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pic_id_seq OWNER TO oecobt;

--
-- TOC entry 1957 (class 0 OID 0)
-- Dependencies: 168
-- Name: pic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oecobt
--

ALTER SEQUENCE pic_id_seq OWNED BY pic.id;


--
-- TOC entry 1958 (class 0 OID 0)
-- Dependencies: 168
-- Name: pic_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('pic_id_seq', 13, true);


--
-- TOC entry 171 (class 1259 OID 184288)
-- Dependencies: 6
-- Name: priority; Type: TABLE; Schema: public; Owner: oecobt; Tablespace: 
--

CREATE TABLE priority (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.priority OWNER TO oecobt;

--
-- TOC entry 170 (class 1259 OID 184286)
-- Dependencies: 171 6
-- Name: priority_id_seq; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE priority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.priority_id_seq OWNER TO oecobt;

--
-- TOC entry 1959 (class 0 OID 0)
-- Dependencies: 170
-- Name: priority_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oecobt
--

ALTER SEQUENCE priority_id_seq OWNED BY priority.id;


--
-- TOC entry 1960 (class 0 OID 0)
-- Dependencies: 170
-- Name: priority_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('priority_id_seq', 3, true);


--
-- TOC entry 165 (class 1259 OID 184173)
-- Dependencies: 6
-- Name: seq_defect; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE seq_defect
    START WITH 1236
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_defect OWNER TO oecobt;

--
-- TOC entry 1961 (class 0 OID 0)
-- Dependencies: 165
-- Name: seq_defect; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('seq_defect', 1246, true);


--
-- TOC entry 161 (class 1259 OID 184141)
-- Dependencies: 6
-- Name: seq_pic; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE seq_pic
    START WITH 1236
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_pic OWNER TO oecobt;

--
-- TOC entry 1962 (class 0 OID 0)
-- Dependencies: 161
-- Name: seq_pic; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('seq_pic', 1250, true);


--
-- TOC entry 164 (class 1259 OID 184165)
-- Dependencies: 6
-- Name: seq_priority; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE seq_priority
    START WITH 1236
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_priority OWNER TO oecobt;

--
-- TOC entry 1963 (class 0 OID 0)
-- Dependencies: 164
-- Name: seq_priority; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('seq_priority', 1239, true);


--
-- TOC entry 163 (class 1259 OID 184157)
-- Dependencies: 6
-- Name: seq_severity; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE seq_severity
    START WITH 1236
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_severity OWNER TO oecobt;

--
-- TOC entry 1964 (class 0 OID 0)
-- Dependencies: 163
-- Name: seq_severity; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('seq_severity', 1238, true);


--
-- TOC entry 162 (class 1259 OID 184149)
-- Dependencies: 6
-- Name: seq_status; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE seq_status
    START WITH 1236
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_status OWNER TO oecobt;

--
-- TOC entry 1965 (class 0 OID 0)
-- Dependencies: 162
-- Name: seq_status; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('seq_status', 1240, true);


--
-- TOC entry 173 (class 1259 OID 184296)
-- Dependencies: 6
-- Name: severity; Type: TABLE; Schema: public; Owner: oecobt; Tablespace: 
--

CREATE TABLE severity (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.severity OWNER TO oecobt;

--
-- TOC entry 172 (class 1259 OID 184294)
-- Dependencies: 6 173
-- Name: severity_id_seq; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE severity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.severity_id_seq OWNER TO oecobt;

--
-- TOC entry 1966 (class 0 OID 0)
-- Dependencies: 172
-- Name: severity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oecobt
--

ALTER SEQUENCE severity_id_seq OWNED BY severity.id;


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 172
-- Name: severity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('severity_id_seq', 4, true);


--
-- TOC entry 175 (class 1259 OID 184304)
-- Dependencies: 6
-- Name: status; Type: TABLE; Schema: public; Owner: oecobt; Tablespace: 
--

CREATE TABLE status (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.status OWNER TO oecobt;

--
-- TOC entry 174 (class 1259 OID 184302)
-- Dependencies: 175 6
-- Name: status_id_seq; Type: SEQUENCE; Schema: public; Owner: oecobt
--

CREATE SEQUENCE status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_id_seq OWNER TO oecobt;

--
-- TOC entry 1968 (class 0 OID 0)
-- Dependencies: 174
-- Name: status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: oecobt
--

ALTER SEQUENCE status_id_seq OWNED BY status.id;


--
-- TOC entry 1969 (class 0 OID 0)
-- Dependencies: 174
-- Name: status_id_seq; Type: SEQUENCE SET; Schema: public; Owner: oecobt
--

SELECT pg_catalog.setval('status_id_seq', 5, true);


--
-- TOC entry 1923 (class 2604 OID 184272)
-- Dependencies: 167 166 167
-- Name: id; Type: DEFAULT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY defect ALTER COLUMN id SET DEFAULT nextval('defect_id_seq'::regclass);


--
-- TOC entry 1924 (class 2604 OID 184283)
-- Dependencies: 169 168 169
-- Name: id; Type: DEFAULT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY pic ALTER COLUMN id SET DEFAULT nextval('pic_id_seq'::regclass);


--
-- TOC entry 1925 (class 2604 OID 184291)
-- Dependencies: 171 170 171
-- Name: id; Type: DEFAULT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY priority ALTER COLUMN id SET DEFAULT nextval('priority_id_seq'::regclass);


--
-- TOC entry 1926 (class 2604 OID 184299)
-- Dependencies: 173 172 173
-- Name: id; Type: DEFAULT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY severity ALTER COLUMN id SET DEFAULT nextval('severity_id_seq'::regclass);


--
-- TOC entry 1927 (class 2604 OID 184307)
-- Dependencies: 174 175 175
-- Name: id; Type: DEFAULT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY status ALTER COLUMN id SET DEFAULT nextval('status_id_seq'::regclass);


--
-- TOC entry 1942 (class 0 OID 184269)
-- Dependencies: 167 1947
-- Data for Name: defect; Type: TABLE DATA; Schema: public; Owner: oecobt
--

COPY defect (id, description, estimate, notes, pic, priority, severity, status) FROM stdin;
1	test 1	1	\N	1	1	1	1
3	test 3	3	\N	3	3	3	3
2	test 2	2	\N	2	2	2	2
\.


--
-- TOC entry 1943 (class 0 OID 184280)
-- Dependencies: 169 1947
-- Data for Name: pic; Type: TABLE DATA; Schema: public; Owner: oecobt
--

COPY pic (id, name) FROM stdin;
1	irfan
2	herry
3	beni
4	surya
5	arif
6	purba
7	nanda
8	kiki
9	ika
10	kyla
11	ayu
12	wujud
13	andik
\.


--
-- TOC entry 1944 (class 0 OID 184288)
-- Dependencies: 171 1947
-- Data for Name: priority; Type: TABLE DATA; Schema: public; Owner: oecobt
--

COPY priority (id, name) FROM stdin;
1	High
2	Medum
3	Low
\.


--
-- TOC entry 1945 (class 0 OID 184296)
-- Dependencies: 173 1947
-- Data for Name: severity; Type: TABLE DATA; Schema: public; Owner: oecobt
--

COPY severity (id, name) FROM stdin;
1	Critical
2	High
3	Medium
4	Low
\.


--
-- TOC entry 1946 (class 0 OID 184304)
-- Dependencies: 175 1947
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: oecobt
--

COPY status (id, name) FROM stdin;
1	New
2	Assigned
3	In Progress
4	Fixed
5	Closed
\.


--
-- TOC entry 1929 (class 2606 OID 184277)
-- Dependencies: 167 167 1948
-- Name: defect_pkey; Type: CONSTRAINT; Schema: public; Owner: oecobt; Tablespace: 
--

ALTER TABLE ONLY defect
    ADD CONSTRAINT defect_pkey PRIMARY KEY (id);


--
-- TOC entry 1931 (class 2606 OID 184285)
-- Dependencies: 169 169 1948
-- Name: pic_pkey; Type: CONSTRAINT; Schema: public; Owner: oecobt; Tablespace: 
--

ALTER TABLE ONLY pic
    ADD CONSTRAINT pic_pkey PRIMARY KEY (id);


--
-- TOC entry 1933 (class 2606 OID 184293)
-- Dependencies: 171 171 1948
-- Name: priority_pkey; Type: CONSTRAINT; Schema: public; Owner: oecobt; Tablespace: 
--

ALTER TABLE ONLY priority
    ADD CONSTRAINT priority_pkey PRIMARY KEY (id);


--
-- TOC entry 1935 (class 2606 OID 184301)
-- Dependencies: 173 173 1948
-- Name: severity_pkey; Type: CONSTRAINT; Schema: public; Owner: oecobt; Tablespace: 
--

ALTER TABLE ONLY severity
    ADD CONSTRAINT severity_pkey PRIMARY KEY (id);


--
-- TOC entry 1937 (class 2606 OID 184309)
-- Dependencies: 175 175 1948
-- Name: status_pkey; Type: CONSTRAINT; Schema: public; Owner: oecobt; Tablespace: 
--

ALTER TABLE ONLY status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- TOC entry 1940 (class 2606 OID 184320)
-- Dependencies: 173 167 1934 1948
-- Name: fkb063c9712cdf8f70; Type: FK CONSTRAINT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY defect
    ADD CONSTRAINT fkb063c9712cdf8f70 FOREIGN KEY (severity) REFERENCES severity(id);


--
-- TOC entry 1941 (class 2606 OID 184325)
-- Dependencies: 167 1930 169 1948
-- Name: fkb063c971957367de; Type: FK CONSTRAINT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY defect
    ADD CONSTRAINT fkb063c971957367de FOREIGN KEY (pic) REFERENCES pic(id);


--
-- TOC entry 1939 (class 2606 OID 184315)
-- Dependencies: 1936 167 175 1948
-- Name: fkb063c971cc58eeda; Type: FK CONSTRAINT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY defect
    ADD CONSTRAINT fkb063c971cc58eeda FOREIGN KEY (status) REFERENCES status(id);


--
-- TOC entry 1938 (class 2606 OID 184310)
-- Dependencies: 171 167 1932 1948
-- Name: fkb063c971f1b65cbe; Type: FK CONSTRAINT; Schema: public; Owner: oecobt
--

ALTER TABLE ONLY defect
    ADD CONSTRAINT fkb063c971f1b65cbe FOREIGN KEY (priority) REFERENCES priority(id);


--
-- TOC entry 1953 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-03-19 15:52:30 WIT

--
-- PostgreSQL database dump complete
--

