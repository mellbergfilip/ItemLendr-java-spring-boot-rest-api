INSERT INTO users (first_name, last_name, email, password, role, created_at)
VALUES
    ('John', 'Doe', 'john@example.com', '$2y$10$fZH8P//C9MQlWzrY0YjqfOjbIbqFzcixMfET3gGX5gFC3el/W0eiG', 'ROLE_ADMIN', NOW()),
    ('Jane', 'Smith', 'jane@example.com', '$2y$10$4fYhTgONH/GAVnUCFNfMOeJYSxoHm1q09Z1HX3MG8fAD82x.yaZSy', 'ROLE_ADMIN', NOW()),
    ('Michael', 'Johnson', 'michael@example.com', '$2y$10$LdOQ2tzjTT02eAS0DbCDru5goaNfyF0CZjLiyyQgCODIyESDl7R.i', 'ROLE_USER', NOW()),
    ('Emily', 'Davis', 'emily@example.com', '$2y$10$k5kMXRxLGq12MRckmPq7K.X/4//ZtKigo3xsP95ce1tpqDUViuBs.', 'ROLE_USER', NOW()),
    ('David', 'Wilson', 'david@example.com', '$2y$10$MZJ55QVdRluB0ER592iedu5u8d785VtstaJQbqSG/.tRqUgYHfeiq', 'ROLE_USER', NOW());

INSERT INTO item_categories (name, created_at)
VALUES
    ('Electronics', NOW()),
    ('Clothing', NOW()),
    ('Books', NOW()),
    ('Home and Garden', NOW()),
    ('Toys and Games', NOW()),
    ('Sports and Outdoors', NOW()),
    ('Beauty and Personal Care', NOW()),
    ('Automotive', NOW()),
    ('Health and Wellness', NOW()),
    ('Pet Supplies', NOW());

INSERT INTO items (name, description, available, category_id, created_at)
VALUES
    ('Laptop X1', 'Powerful laptop for all your computing needs', true, 1, NOW()),
    ('Wireless Keyboard', 'Bluetooth keyboard with ergonomic design', true, 2, NOW()),
    ('Smartphone Z2', 'High-performance smartphone with advanced features', true, 3, NOW()),
    ('WiFi Router', 'Dual-band router for fast and reliable internet', true, 4, NOW()),
    ('Graphic Design Software', 'Professional software for graphic designers', true, 5, NOW()),
    ('Gaming Console', 'Latest gaming console with HD graphics', true, 6, NOW()),
    ('External Hard Drive', '1TB external HDD for extra storage', true, 7, NOW()),
    ('Office Chair', 'Ergonomic chair for comfortable workspace', true, 8, NOW()),
    ('Smart TV 50"', 'Large smart TV with 4K resolution', true, 1, NOW()),
    ('Wireless Mouse', 'Precision wireless mouse for easy navigation', true, 2, NOW()),
    ('Fitness Tracker', 'Tracks your steps, heart rate, and more', true, 3, NOW()),
    ('Ethernet Switch', '8-port Gigabit Ethernet switch', true, 4, NOW()),
    ('Video Editing Software', 'Professional software for video editing', true, 5, NOW()),
    ('Virtual Reality Headset', 'Immersive VR headset for gaming and experiences', true, 6, NOW()),
    ('SSD Drive', 'High-speed 500GB SSD for fast data access', true, 7, NOW()),
    ('Adjustable Standing Desk', 'Height-adjustable desk for ergonomic workspace', true, 8, NOW()),
    ('Smart Thermostat', 'Wi-Fi enabled thermostat for home automation', true, 1, NOW()),
    ('Bluetooth Earbuds', 'Wireless earbuds with noise cancellation', true, 2, NOW());


INSERT INTO bookings (item_id, user_id, booking_date, start_date, end_date, status, created_at, last_modified)
VALUES
    (1, 1, NOW(), NOW(), NOW(), 'PENDING', NOW(), NOW()),
    (2, 2, NOW(), NOW(), NOW(), 'APPROVED', NOW(), NOW()),
    (3, 3, NOW(), NOW(), NOW(), 'DECLINED', NOW(), NOW()),
    (4, 4, NOW(), NOW(), NOW(), 'CANCELED', NOW(), NOW()),
    (5, 5, NOW(), NOW(), NOW(), 'CHECKEDOUT', NOW(), NOW());


