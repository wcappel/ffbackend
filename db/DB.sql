DROP DATABASE IF EXISTS ffsmall;

CREATE DATABASE ffsmall;

USE ffsmall;

CREATE TABLE Users (
	Username VARCHAR(20) NOT NULL UNIQUE,
	Email VARCHAR(45) NOT NULL UNIQUE,
	PRIMARY KEY (Username)
);

CREATE TABLE Leagues (
	League_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
	Name VARCHAR(50) NOT NULL,
	Commissioner VARCHAR(20),
	Current_week TINYINT,
	Pre_match BOOL,
	Logo_url VARCHAR(200),
	PRIMARY KEY (League_ID),
	FOREIGN KEY (Commissioner) REFERENCES Users(Username)
);

CREATE TABLE Teams (
	Team_name VARCHAR(30) NOT NULL,
	League INT NOT NULL,
	Owner VARCHAR(20) NOT NULL,
	Wins TINYINT,
	Losses TINYINT,
	Ties TINYINT,
	On_bye BOOL,
	Logo_url VARCHAR(200),
	PRIMARY KEY (Team_name, League),
	FOREIGN KEY (League) REFERENCES Leagues(League_ID),
	FOREIGN KEY (Owner) REFERENCES Users(Username)
);

CREATE TABLE Players (
	Name VARCHAR(50) NOT NULL,
	Position VARCHAR(4) NOT NULL,
	PRIMARY KEY (Name, Position)
);

CREATE TABLE PlayerScores (
	Name VARCHAR(50) NOT NULL,
	NFL_team VARCHAR(3) NOT NULL,
	Position VARCHAR(4) NOT NULL,
	Week TINYINT NOT NULL,
	Available BOOL,
	Fantasy_points FLOAT(5, 2),
	PRIMARY KEY (Name, Position, Week),
	FOREIGN KEY (Name, Position) REFERENCES Players(Name, Position)
);

CREATE TABLE Rosters (
	Player_name VARCHAR(50) NOT NULL,
	Position VARCHAR(4) NOT NULL,
	League INT NOT NULL,
	Rostered VARCHAR(30),
	Roster_position VARCHAR(4),
	PRIMARY KEY(Player_name, Position, League),
	FOREIGN KEY (Player_name, Position) REFERENCES Players(Name, Position),
	FOREIGN KEY (Rostered, League) REFERENCES Teams(Team_name, League)
);

CREATE TABLE Trades (
	Trade_id INT NOT NULL,
	League INT NOT NULL,
	initiatedBy VARCHAR(30) NOT NULL,
	proposedTo VARCHAR(30) NOT NULL,
	User_approved BOOL,
	Comm_approved BOOL,
	initP1Name VARCHAR(50) NOT NULL,
	initP1Pos VARCHAR(4) NOT NULL,
	initP2Name VARCHAR(50),
	initP2Pos VARCHAR(4),
	initP3Name VARCHAR(50),
	initP3Pos VARCHAR(4),
	propP1Name VARCHAR(50) NOT NULL,
	propP1Pos VARCHAR(4) NOT NULL,
	propP2Name VARCHAR(50),
	propP2Pos VARCHAR(4),
	propP3Name VARCHAR(50),
	propP3Pos VARCHAR(4),
	PRIMARY KEY (Trade_id, League),
	FOREIGN KEY (initiatedBy, League) REFERENCES Teams(Team_name, League),
	FOREIGN KEY (proposedTo, League) REFERENCES Teams(Team_name, League),
	FOREIGN KEY (initP1Name, initP1Pos, League) REFERENCES Rosters(Player_name, Position, League),
	FOREIGN KEY (initP2Name, initP2Pos, League) REFERENCES Rosters(Player_name, Position, League),
	FOREIGN KEY (initP3Name, initP3Pos, League) REFERENCES Rosters(Player_name, Position, League),
	FOREIGN KEY (propP1Name, propP1Pos, League) REFERENCES Rosters(Player_name, Position, League),
	FOREIGN KEY (propP2Name, propP2Pos, League) REFERENCES Rosters(Player_name, Position, League),
	FOREIGN KEY (propP3Name, propP3Pos, League) REFERENCES Rosters(Player_name, Position, League)
);

CREATE TABLE Matchups (
	League INT NOT NULL,
	League_match_num INT NOT NULL UNIQUE AUTO_INCREMENT,
	Week TINYINT NOT NULL,
	homeTeam VARCHAR(30) NOT NULL,
	awayTeam VARCHAR(30) NOT NULL,
	Home_score FLOAT(5, 2),
	Away_score FLOAT(5, 2),
	PRIMARY KEY(League, League_match_num),
	FOREIGN KEY (League) REFERENCES Leagues(League_ID),
	FOREIGN KEY (homeTeam, League) REFERENCES Teams(Team_name, League),
	FOREIGN KEY (awayTeam, League) REFERENCES Teams(Team_name, League)
);

