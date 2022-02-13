USE Shubham200469159;

DROP TABLE IF EXISTS weather_data;

/*
formattedDate 
precipType
temp
apparentTemp
windSpeed
dailySummary
*/
CREATE TABLE IF NOT EXISTS weather_data (
  weatherDayId INT NOT NULL AUTO_INCREMENT,
  formattedDate INT,
  precipType varchar(50),
  temp float,
  apparentTemp float, 
  windSpeed float,
  dailySummary varchar(50),
  PRIMARY KEY (weatherDayId));
  
  select * from weather_data;