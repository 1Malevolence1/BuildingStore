
CREATE TABLE IF NOT EXISTS public.product_type (
    product_type_id BIGSERIAL PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS public.product (
    product_id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(19, 4) NOT NULL,
    stock BIGINT,
    product_type_id integer not null,
    FOREIGN KEY (product_type_id) REFERENCES public.product_type(product_type_id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS  public.store (
    store_id SERIAL PRIMARY KEY,
    store_name VARCHAR(100) NOT NULL,
    location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.inventory (
    inventory_id BIGSERIAL PRIMARY KEY,
    quantity BIGINT,
    date DATE,
    product_id BIGINT,
    store_id bigint,

    FOREIGN KEY (product_id) REFERENCES public.product(product_id) ON DELETE CASCADE,
    FOREIGN KEY (store_id) REFERENCES public.store(store_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS  public.position (
    position_id BIGSERIAL PRIMARY KEY,
    position_name VARCHAR(255) NOT NULL,
    salary DECIMAL(19, 2)
);


CREATE TABLE IF NOT EXISTS public.employee (
    employee_id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    position_id BIGINT,
    store_id BIGINT,
    FOREIGN KEY (position_id) REFERENCES public.position(position_id) ON DELETE CASCADE,
    FOREIGN KEY (store_id) REFERENCES public.store(store_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS public.customer (
    customer_id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    email VARCHAR(100),
    address VARCHAR(255)
);



CREATE TABLE IF NOT EXISTS public.sale (
    sale_id BIGSERIAL PRIMARY KEY,
    sale_date DATE,
    total_amount NUMERIC(15, 2),
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS public.sale_detail (
    sale_detail_id SERIAL PRIMARY KEY,
    quantity BIGINT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    sale_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES public.sale (sale_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES public.product (product_id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS public.orders (
    order_id SERIAL PRIMARY KEY,
    order_date DATE NOT NULL,
    status VARCHAR(50),
    store_id BIGINT,
    FOREIGN KEY (store_id) REFERENCES public.store(store_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS public.order_detail (
    order_detail_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT,
    product_id BIGINT,
    quantity BIGINT,
    FOREIGN KEY (order_id) REFERENCES public.orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES public.product(product_id)
);


CREATE TABLE IF NOT EXISTS public.supplier (
    supplier_id SERIAL primary key ,
    supply_date DATE,
    quantity BIGINT,
    product_id BIGINT,
    order_id BIGINT,

    foreign key (product_id) references public.product(product_id),
    foreign key  (order_id) references  public.orders(order_id)
);


CREATE TABLE IF NOT EXISTS public.payment (
    payment_id SERIAL PRIMARY KEY,
    payment_date DATE,
    amount NUMERIC(19, 4),
    sale_id BIGINT,

    foreign key (sale_id) references public.sale(sale_id)
);
