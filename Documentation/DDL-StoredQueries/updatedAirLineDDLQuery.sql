create database AirlineTicket;
use AirlineTicket;

create table Trip_Source_Destination (
TripId int primary key not null auto_increment,
sourceCityName varchar(45) not null,
sourceCountry varchar(45) not null,
DestCityName varchar(45) not null,
DestCountry varchar(45) not null,
constraint uk_Src_Dest_pair unique(sourceCityName,DestCityName)
);

create Table Airline(
AirlineId int primary key not null auto_increment,
AirlineName varchar(45),
constraint uk_airline_nm unique(AirlineName)
);

create table FlightRunningDays(
FlightScheduleId int primary key not null auto_increment,
Monday boolean not null default 0,
Tuesday boolean not null default 0,
Wednesday boolean not null default 0,
Thursday boolean not null default 0,
Friday boolean not null default 0,
Saturday boolean not null default 0,
Sunday boolean not null default 0
);


create table FlightDetail(
FlightId int primary key not null auto_increment,
TripId int not null,
AirlineId int not null,
TicketPrice double not null,
FlightScheduleId int not null,
departureTime time not null,
TravelDuration time not null,
foreign key (TripId) references Trip_Source_Destination(TripId),
foreign key (AirLineId) references AirLine(AirLineId),
foreign key (FlightScheduleId) references FlightRunningDays(FlightScheduleId)
);

create Table FlightAvailabilityByDate(
FlightTripId int primary key not null auto_increment, 
FlightId int not null,foreign key(FlightId) references FlightDetail(FlightId),
TravelDate date not null,
NoOfTickets int not null,
 constraint uk_duplicate unique(flightid,travelDate));
 
 
alter table FlightAvailabilityByDate add constraint uk_duplicate unique(flightid,travelDate);
desc FlightAvailabilityByDate;

drop table FlightAvailabilityByDate;
drop table FlightRunningDays;
drop table FlightDetail;
drop table Airline;
drop table Trip_Source_Destination;

drop database airlineticket;

alter table Airline add constraint uk_airline_nm unique(AirlineName);

alter table Trip_Source_Destination modify column TripId int auto_increment;

alter table Trip_Source_Destination add constraint uk_Src_Dest_pair unique(sourceCityName,DestCityName);

alter table flightdetail add column departureTime time not null, add column TravelDuration time not null;
desc FlightRunningDays;

drop table FlightRunningDays1;
create table FlightRunningDays(
FlightId int not null,
constraint uk_flightId1
unique(FlightId),
Monday int not null default 0,
Tuesday int not null default 0,
Wednesday int not null default 0,
Thursday int not null default 0,
Friday int not null default 0,
Saturday int not null default 0,
Sunday int not null default 0,
constraint fk_flight12
foreign key (FlightId) references FlightDetail(FlightId)
);


alter table FlightRunningDays add column flightRunningId int not null auto_increment, add constraint pk_flightRunDay primary key (flightRunningId);

desc FlightAvailabilityByDate;

alter table FlightAvailabilityByDate add column FlightTripId int not null auto_increment, add constraint pk_flightTrip primary key (FlightTripId);

alter table FlightAvailabilityByDate add constraint uk_duplicate unique(flightid,travelDate);
