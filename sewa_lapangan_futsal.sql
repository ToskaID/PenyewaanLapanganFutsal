PGDMP         7                {            sewa_lapangan_futsal    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    59626    sewa_lapangan_futsal    DATABASE     �   CREATE DATABASE sewa_lapangan_futsal WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Indonesia.1252';
 $   DROP DATABASE sewa_lapangan_futsal;
                postgres    false            �            1259    59820    boking    TABLE     H  CREATE TABLE public.boking (
    id character varying(100) NOT NULL,
    tanggal_boking date,
    tanggal_main date,
    jam_main time without time zone,
    jam_selesai time without time zone,
    durasi integer,
    uang_boking double precision,
    tenant_id character varying(100),
    lapangan_id character varying(100)
);
    DROP TABLE public.boking;
       public         heap    postgres    false            �            1259    59835    konfirmasi_pembayaran    TABLE     �   CREATE TABLE public.konfirmasi_pembayaran (
    id character varying(100) NOT NULL,
    total double precision,
    boking_id character varying(100)
);
 )   DROP TABLE public.konfirmasi_pembayaran;
       public         heap    postgres    false            �            1259    59795    lapangan    TABLE     �   CREATE TABLE public.lapangan (
    id character varying(100) NOT NULL,
    nama_lapangan character varying(20),
    jenis_lapangan character varying(100),
    harga integer
);
    DROP TABLE public.lapangan;
       public         heap    postgres    false            �            1259    59790    tenant    TABLE     �   CREATE TABLE public.tenant (
    id character varying(100) NOT NULL,
    nama_tenant character varying(100),
    no_hp character varying(100)
);
    DROP TABLE public.tenant;
       public         heap    postgres    false                      0    59820    boking 
   TABLE DATA           �   COPY public.boking (id, tanggal_boking, tanggal_main, jam_main, jam_selesai, durasi, uang_boking, tenant_id, lapangan_id) FROM stdin;
    public          postgres    false    216                    0    59835    konfirmasi_pembayaran 
   TABLE DATA           E   COPY public.konfirmasi_pembayaran (id, total, boking_id) FROM stdin;
    public          postgres    false    217   �       
          0    59795    lapangan 
   TABLE DATA           L   COPY public.lapangan (id, nama_lapangan, jenis_lapangan, harga) FROM stdin;
    public          postgres    false    215   �       	          0    59790    tenant 
   TABLE DATA           8   COPY public.tenant (id, nama_tenant, no_hp) FROM stdin;
    public          postgres    false    214          u           2606    59824    boking boking_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.boking
    ADD CONSTRAINT boking_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.boking DROP CONSTRAINT boking_pkey;
       public            postgres    false    216            w           2606    59839 0   konfirmasi_pembayaran konfirmasi_pembayaran_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.konfirmasi_pembayaran
    ADD CONSTRAINT konfirmasi_pembayaran_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.konfirmasi_pembayaran DROP CONSTRAINT konfirmasi_pembayaran_pkey;
       public            postgres    false    217            s           2606    59799    lapangan lapangan_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.lapangan
    ADD CONSTRAINT lapangan_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.lapangan DROP CONSTRAINT lapangan_pkey;
       public            postgres    false    215            q           2606    59794    tenant tenant_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.tenant
    ADD CONSTRAINT tenant_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.tenant DROP CONSTRAINT tenant_pkey;
       public            postgres    false    214            z           2606    59840 "   konfirmasi_pembayaran fk_boking_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.konfirmasi_pembayaran
    ADD CONSTRAINT fk_boking_id FOREIGN KEY (boking_id) REFERENCES public.boking(id);
 L   ALTER TABLE ONLY public.konfirmasi_pembayaran DROP CONSTRAINT fk_boking_id;
       public          postgres    false    216    3189    217            x           2606    59830    boking fk_lapangan_id    FK CONSTRAINT     {   ALTER TABLE ONLY public.boking
    ADD CONSTRAINT fk_lapangan_id FOREIGN KEY (lapangan_id) REFERENCES public.lapangan(id);
 ?   ALTER TABLE ONLY public.boking DROP CONSTRAINT fk_lapangan_id;
       public          postgres    false    216    215    3187            y           2606    59825    boking fk_tenant_id    FK CONSTRAINT     u   ALTER TABLE ONLY public.boking
    ADD CONSTRAINT fk_tenant_id FOREIGN KEY (tenant_id) REFERENCES public.tenant(id);
 =   ALTER TABLE ONLY public.boking DROP CONSTRAINT fk_tenant_id;
       public          postgres    false    216    214    3185               �   x��αmC1��ZoG>R�<D&p#J��#؅�>@�tq8|ёؽ(2�t��yӖ
��k7�0�	�'���`i,������6�C��nZS���qoY�V5��{�k��O�B P��Z����E�NOZ��|�G�}�l����)G�0���Q�GlY�����uϯ�^	p�         �   x���ˍD1��ra��'��0�?�uO�k�J�+k�f����u�߻?�I�Ʋ�M�Ai-P|�)���CھT�m&ȑ	V�|�Z������w� ߧA3��AȺAl�z+V�|���ZG ]��p�����6c�У׫E!��2wl��oY^UI���w��bV���BKc:oYw]:J¤�s0d� �q��m���}���=��      
   K   x�KM351MK��557L�5I47е��4�M3H2000107JN��I,H�KO�S0F0�3�JRK2�9M�
�b���� 7�      	   F   x�KJ4H6�0L�5�HM�5I�H�M�4J�M502K1�L�0M���M,)Q�H,J��4�042�42����� [     