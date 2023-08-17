INSERT INTO users (first_name, last_name, email, password, role, created_at)
VALUES
    ('John', 'Doe', 'john@example.com', '$2y$10$fZH8P//C9MQlWzrY0YjqfOjbIbqFzcixMfET3gGX5gFC3el/W0eiG', 'ROLE_ADMIN', NOW()),
    ('Jane', 'Smith', 'jane@example.com', '$2y$10$4fYhTgONH/GAVnUCFNfMOeJYSxoHm1q09Z1HX3MG8fAD82x.yaZSy', 'ROLE_ADMIN', NOW()),
    ('Michael', 'Johnson', 'michael@example.com', '$2y$10$LdOQ2tzjTT02eAS0DbCDru5goaNfyF0CZjLiyyQgCODIyESDl7R.i', 'ROLE_USER', NOW()),
    ('Emily', 'Davis', 'emily@example.com', '$2y$10$k5kMXRxLGq12MRckmPq7K.X/4//ZtKigo3xsP95ce1tpqDUViuBs.', 'ROLE_USER', NOW()),
    ('David', 'Wilson', 'david@example.com', '$2y$10$MZJ55QVdRluB0ER592iedu5u8d785VtstaJQbqSG/.tRqUgYHfeiq', 'ROLE_USER', NOW());

INSERT INTO items (name, description, available, item_category, created_at)
VALUES
    ('Laptop X1', 'Powerful laptop for all your computing needs', true, 'ELECTRONICS', NOW()),
    ('Wireless Keyboard', 'Bluetooth keyboard with ergonomic design', true, 'ACCESSORIES', NOW()),
    ('Smartphone Z2', 'High-performance smartphone with advanced features', true, 'GADGETS', NOW()),
    ('WiFi Router', 'Dual-band router for fast and reliable internet', true, 'NETWORKING', NOW()),
    ('Graphic Design Software', 'Professional software for graphic designers', true, 'SOFTWARE', NOW()),
    ('Gaming Console', 'Latest gaming console with HD graphics', true, 'GAMING', NOW()),
    ('External Hard Drive', '1TB external HDD for extra storage', true, 'STORAGE', NOW()),
    ('Office Chair', 'Ergonomic chair for comfortable workspace', true, 'FURNITURE', NOW()),
    ('Smart TV 50"', 'Large smart TV with 4K resolution', true, 'ELECTRONICS', NOW()),
    ('Wireless Mouse', 'Precision wireless mouse for easy navigation', true, 'ACCESSORIES', NOW()),
    ('Fitness Tracker', 'Tracks your steps, heart rate, and more', true, 'GADGETS', NOW()),
    ('Ethernet Switch', '8-port Gigabit Ethernet switch', true, 'NETWORKING', NOW()),
    ('Video Editing Software', 'Professional software for video editing', true, 'SOFTWARE', NOW()),
    ('Virtual Reality Headset', 'Immersive VR headset for gaming and experiences', true, 'GAMING', NOW()),
    ('SSD Drive', 'High-speed 500GB SSD for fast data access', true, 'STORAGE', NOW()),
    ('Adjustable Standing Desk', 'Height-adjustable desk for ergonomic workspace', true, 'FURNITURE', NOW()),
    ('Smart Thermostat', 'Wi-Fi enabled thermostat for home automation', true, 'ELECTRONICS', NOW()),
    ('Bluetooth Earbuds', 'Wireless earbuds with noise cancellation', true, 'ACCESSORIES', NOW());