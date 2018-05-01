--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE note (
    note_id bigint NOT NULL,
    create_date date,
    note character varying(255),
    user_id bigint,
    header character varying(255),
    priority character varying(255)
);


ALTER TABLE note OWNER TO postgres;

--
-- Name: note_note_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE note_note_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE note_note_id_seq OWNER TO postgres;

--
-- Name: note_note_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE note_note_id_seq OWNED BY note.note_id;


--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "user" (
    id bigint NOT NULL,
    password character varying(255),
    role character varying(255),
    status character varying(255),
    username character varying(255)
);


ALTER TABLE "user" OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- Name: note note_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY note ALTER COLUMN note_id SET DEFAULT nextval('note_note_id_seq'::regclass);


--
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- Data for Name: note; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY note (note_id, create_date, note, user_id, header, priority) FROM stdin;
2	2018-04-30	no pain \r\nno gain	1	VERY Impotan	CRITICAL
3	2018-04-30	if u do something, do something\r\n	1	abc	TRIVIAL
4	2018-04-30	banana\r\npotato\r\nmilk\r\nflowers for wife\r\nice cream for childs	1	buy list	MAJOR
9	2018-05-01	coco jambo	4	Put me up, put me down, Put my feedback on the ground	MINOR
10	2018-05-01	text	4	still text	TRIVIAL
11	2018-05-01	test	4	still text	TRIVIAL
13	2018-05-01	text	5	qq	TRIVIAL
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "user" (id, password, role, status, username) FROM stdin;
1	$2a$12$QdRHqVukzVJYnpXlSBsoY.4fOCe55q8AuptrOWbpOI1bWDHM3xYfG	ADMIN	ACTIVE	12
4	$2a$12$70agasW8vZkgCRC/zBFZ0.lid/d12ZvSzo704iFPIh5uC2BZCXlqG	USER	ACTIVE	123
5	$2a$10$9HTocaRjpLqfuDPMrMkqzOldLeC2WecBkJ6RZr31jI6giN04/K/ZS	USER	ACTIVE	pp
\.


--
-- Name: note_note_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('note_note_id_seq', 13, true);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 5, true);


--
-- Name: note note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY note
    ADD CONSTRAINT note_pkey PRIMARY KEY (note_id);


--
-- Name: user uk_sb8bbouer5wak8vyiiy4pf2bx; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT uk_sb8bbouer5wak8vyiiy4pf2bx UNIQUE (username);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: note fkmoddtnuw3yy6ct34xnw6u0boh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY note
    ADD CONSTRAINT fkmoddtnuw3yy6ct34xnw6u0boh FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- PostgreSQL database dump complete
--

