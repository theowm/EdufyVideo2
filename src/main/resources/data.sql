INSERT INTO genres (genre_id, name) VALUES
('11111111-1111-1111-1111-111111111111', 'Education'),
('22222222-2222-2222-2222-222222222222', 'Science'),
('33333333-3333-3333-3333-333333333333', 'Technology'),
('44444444-4444-4444-4444-444444444444', 'History'),
('55555555-5555-5555-5555-555555555555', 'Mathematics');



INSERT INTO videos (video_id, title, stream_url, uploader_id) VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Physics Basics', 'https://cdn.example.com/videos/physics-basics.mp4', '11111111-1111-1111-1111-111111111111'),
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Ancient Rome Documentary', 'https://cdn.example.com/videos/rome-docu.mp4', '11111111-1111-1111-1111-111111111111'),
('cccccccc-cccc-cccc-cccc-cccccccccccc', 'Intro to Programming', 'https://cdn.example.com/videos/programming-intro.mp4', '11111111-1111-1111-1111-111111111111');



INSERT INTO video_genres (video_id, genre_id) VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '11111111-1111-1111-1111-111111111111'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '22222222-2222-2222-2222-222222222222');

INSERT INTO video_genres (video_id, genre_id) VALUES
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '44444444-4444-4444-4444-444444444444'),
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '11111111-1111-1111-1111-111111111111');

INSERT INTO video_genres (video_id, genre_id) VALUES
('cccccccc-cccc-cccc-cccc-cccccccccccc', '33333333-3333-3333-3333-333333333333'),
('cccccccc-cccc-cccc-cccc-cccccccccccc', '11111111-1111-1111-1111-111111111111');