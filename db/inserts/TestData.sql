# Dummy test data for DB
# Insert after populating w/ Player data
# Then can add PlayerScores week by week

INSERT INTO Users(Username) VALUES 
	('Lublite'),
	('RBERT'),
	('chris456'),
	('g3org3');

INSERT INTO Leagues(Name, Current_week, Commissioner, Pre_match) VALUES
	('Awesome League', 1, 'RBERT', TRUE);

INSERT INTO Teams(Team_name, League, Owner, Wins, Losses, Ties, On_bye, Logo_url) VALUES
	('Candy Crushers', 1, 'chris456', 0, 0, 0, FALSE, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvectorified.com%2Fimages%2Fcandy-crush-icon-18.png&f=1&nofb=1'),
	('Delaware Clams', 1, 'RBERT', 0, 0, 0, FALSE, 'https://uploads-ssl.webflow.com/5e7b9a9b32e915d01c9bfd3c/5ea324ff62e3264095a0fae5_pangea%20shellfish%20hard%20shell%20clams.jpg'),
	('Leet Squad', 1, 'g3org3', 0, 0, 0, FALSE, 'https://64.media.tumblr.com/tumblr_mb4xondpXo1rsc925o1_r1_500.png'),
	('Valleyside Vultures', 1, 'Lublite', 0, 0, 0, FALSE, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic.planetminecraft.com%2Ffiles%2Fresource_media%2Fscreenshot%2F1318%2F2013-04-28_213415_5349057_lrg.jpg&f=1&nofb=1');

INSERT INTO Rosters(Player_name, Position, League, Rostered, Roster_position) VALUES
	('John Ross', 'WR', 1, 'Valleyside Vultures', 'WR1'),
	('Josh Gordon', 'WR', 1, 'Leet Squad', 'WR1'),
	('Patrick Mahomes', 'QB', 1, 'Candy Crushers', 'QB'),
	('Tom Brady', 'QB', 1, 'Leet Squad', 'QB'),
	('Russell Wilson', 'QB', 1, 'Delaware Clams', 'QB'),
	('Josh Allen', 'QB', 1, 'Valleyside Vultures', 'QB'),
	('Derrick Henry', 'RB', 1, 'Valleyside Vultures', 'RB1'),
	('Christian McCaffrey', 'RB', 1, 'Candy Crushers', 'RB1'),
	('Nick Chubb', 'RB', 1, 'Candy Crushers', 'RB2'),
	('Leonard Fournette', 'RB', 1, 'Leet Squad', 'RB1'),
	("Le'Veon Bell", 'RB', 1, 'Delaware Clams', 'RB1'),
	('Saquon Barkley', 'RB', 1, 'Leet Squad', 'RB2'),
	('Ezekiel Elliott', 'RB', 1, 'Delaware Clams', 'RB2'),
	('Rex Burkhead', 'RB', 1, 'Valleyside Vultures', 'RB2'),
	('Brandin Cooks', 'WR', 1, 'Delaware Clams', 'WR1'),
	('Marvin Jones', 'WR', 1, 'Leet Squad', 'WR2'),
	('Michael Thomas', 'WR', 1, 'Valleyside Vultures', 'WR2'),
	('Danny Amendola', 'WR', 1, 'Candy Crushers', 'WR1'),
	('D.K. Metcalf', 'WR', 1, 'Candy Crushers', 'WR2'),
	('Amari Cooper', 'WR', 1, 'Delaware Clams', 'WR2'),
	('Hunter Henry', 'TE', 1, 'Valleyside Vultures', 'TE'),
	('George Kittle', 'TE', 1, 'Valleyside Vultures', 'FLEX'),
	('Evan Engram', 'TE', 1, 'Candy Crushers', 'TE'),
	('Mark Andrews', 'TE', 1, 'Candy Crushers', 'FLEX'),
	('Greg Olsen', 'TE', 1, 'Leet Squad', 'TE'),
	('Jimmy Graham', 'TE', 1, 'Leet Squad', 'FLEX'),
	('Tyler Eifert', 'TE', 1, 'Delaware Clams', 'TE'),
	('T.J. Hockenson', 'TE', 1, 'Delaware Clams', 'FLEX');

INSERT INTO Trades(Trade_id, League, initiatedBy, proposedTo, User_approved, Comm_approved, 
	initP1Name, initP1Pos, propP1Name, propP1Pos) VALUES
	('1', '1', 'Delaware Clams', 'Leet Squad', FALSE, FALSE, 'Ezekiel Elliott', 'RB', 'Leonard Fournette', 'RB');

INSERT INTO Matchups(League, League_match_num, Week, homeTeam, awayTeam, Home_score, Away_score) VALUES
	(1, 1, 1, 'Valleyside Vultures', 'Delaware Clams', 0, 0),
	(1, 2, 1, 'Leet Squad', 'Candy Crushers', 0, 0),
	(1, 3, 2, 'Delaware Clams', 'Leet Squad', 0, 0),
	(1, 4, 2, 'Candy Crushers', 'Valleyside Vultures', 0, 0);