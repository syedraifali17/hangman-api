-- INSERT INTO words (word, hint1, hint2, category)
-- We use INSERT ... WHERE NOT EXISTS to avoid duplicate inserts every restart
-- This checks: only insert this word if a row with this word doesn't already exist

INSERT INTO words (word, hint1, hint2, category)
SELECT 'pizza', 'It is a popular Italian dish', 'It is usually round and baked in an oven','Food'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'pizza');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'guitar', 'It is a musical instrument', 'It has six strings', 'Music'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'guitar');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'elephant', 'It is the largest land animal', 'It has a long trunk', 'Animals'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'elephant');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'computer', 'It is an electronic device', 'You are probably using one right now', 'Technology'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'computer');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'chocolate', 'It is a sweet food', 'It is made from cocoa beans', 'Food'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'chocolate');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'volcano', 'It is a geological formation', 'It can erupt with lava', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'volcano');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'butterfly', 'It is an insect', 'It starts life as a caterpillar', 'Animals'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'butterfly');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'pyramid', 'It is an ancient structure', 'Famous ones are found in Egypt', 'History'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'pyramid');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'oxygen', 'It is essential for breathing', 'It is a chemical element with symbol O', 'Science'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'oxygen');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'keyboard', 'It is a computer accessory', 'You use it to type', 'Technology'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'keyboard');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'thunder', 'It happens during a storm', 'It is the sound caused by lightning', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'thunder');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'library', 'It is a public building', 'It is full of books you can borrow', 'Places'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'library');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'diamond', 'It is a precious stone', 'It is the hardest natural substance', 'Science'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'diamond');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'hospital', 'It is a building where sick people go', 'It is full of doctors and nurses', 'Places'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'hospital');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'penguin', 'It is a bird that cannot fly', 'It lives in Antarctica', 'Animals'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'penguin');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'umbrella', 'You use it when it rains', 'It opens up to protect you from water', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'umbrella');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'basketball', 'It is a sport', 'It is played with an orange ball and a hoop', 'Sports'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'basketball');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'rainbow', 'It appears after rain', 'It has seven colors', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'rainbow');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'submarine', 'It is a vehicle', 'It travels underwater', 'Technology'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'submarine');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'microscope', 'It is a scientific instrument', 'It makes tiny things look bigger', 'Science'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'microscope');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'passport', 'It is an official document', 'You need it to travel between countries', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'passport');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'skeleton', 'It is inside your body', 'It is made of bones', 'Science'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'skeleton');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'compass', 'It is a navigation tool', 'It always points north', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'compass');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'trumpet', 'It is a musical instrument', 'It is made of brass and you blow into it', 'Music'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'trumpet');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'spinach', 'It is a vegetable', 'Popeye the sailor loved eating it', 'Food'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'spinach');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'avalanche', 'It is a natural disaster', 'It involves a large mass of snow sliding down a mountain', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'avalanche');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'dolphin', 'It is a sea mammal', 'It is known for being very intelligent', 'Animals'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'dolphin');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'football', 'It is the most popular sport in the world', 'It is played with a round ball and two goals', 'Sports'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'football');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'telescope', 'It is a scientific instrument', 'It is used to look at stars and planets', 'Science'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'telescope');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'cathedral', 'It is a large building', 'It is a place of Christian worship', 'Places'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'cathedral');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'hurricane', 'It is an extreme weather event', 'It is a very powerful rotating storm', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'hurricane');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'crocodile', 'It is a reptile', 'It lives near rivers and has very sharp teeth', 'Animals'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'crocodile');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'saxophone', 'It is a musical instrument', 'It is made of brass but belongs to the woodwind family', 'Music'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'saxophone');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'algorithm', 'It is a computer science concept', 'It is a step by step set of instructions to solve a problem', 'Technology'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'algorithm');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'champagne', 'It is a drink', 'It is a sparkling wine from France', 'Food'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'champagne');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'parachute', 'It is a piece of equipment', 'It slows your fall when jumping from a plane', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'parachute');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'labyrinth', 'It is a structure', 'It is a complicated maze you can get lost in', 'Places'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'labyrinth');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'marathon', 'It is a type of race', 'It is exactly 42.195 kilometers long', 'Sports'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'marathon');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'binoculars', 'It is an optical device', 'It lets you see things that are far away using both eyes', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'binoculars');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'earthquake', 'It is a natural disaster', 'It is caused by movement of tectonic plates', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'earthquake');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'porcupine', 'It is an animal', 'Its body is covered in sharp spines called quills', 'Animals'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'porcupine');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'dentist', 'It is a profession', 'This person takes care of your teeth', 'Professions'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'dentist');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'blackboard', 'It is found in a classroom', 'Teachers write on it with chalk', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'blackboard');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'spaghetti', 'It is an Italian food', 'It is a type of long thin pasta', 'Food'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'spaghetti');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'architect', 'It is a profession', 'This person designs buildings', 'Professions'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'architect');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'quicksand', 'It is found in nature', 'It looks like solid ground but sucks you in', 'Nature'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'quicksand');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'stopwatch', 'It is a device', 'It measures time very precisely', 'Objects'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'stopwatch');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'gymnastics', 'It is a sport', 'It involves acrobatic moves and balance', 'Sports'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'gymnastics');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'plagiarism', 'It is an academic concept', 'It means copying someone elses work and pretending it is yours', 'Education'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'plagiarism');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'encryption', 'It is a technology concept', 'It scrambles data so only authorized people can read it', 'Technology'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'encryption');

INSERT INTO words (word, hint1, hint2, category)
SELECT 'trampoline', 'It is a piece of equipment', 'You jump on it and it bounces you back up', 'Sports'
    WHERE NOT EXISTS (SELECT 1 FROM words WHERE word = 'trampoline');