CREATE TABLE data_pelanggan
(
    id            BIGINT NOT NULL,
    id_pelanggan  VARCHAR(255),
    nama          VARCHAR(255),
    alamat        VARCHAR(255),
    jenis_kelamin VARCHAR(255),
    umur          INTEGER,
    pekerjaan     VARCHAR(255),
    penghasilan   BIGINT,
    CONSTRAINT pk_data_pelanggan PRIMARY KEY (id)
);

ALTER TABLE data_pelanggan
    ADD CONSTRAINT uc_data_pelanggan_id_pelanggan UNIQUE (id_pelanggan);