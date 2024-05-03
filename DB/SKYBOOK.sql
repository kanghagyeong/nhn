DROP DATABASE IF EXISTS `SKYBOOK`;
CREATE DATABASE SKYBOOK;
USE SKYBOOK;

-- 고객분류
DROP TABLE IF EXISTS `CustomerType`;

CREATE TABLE `CustomerType` (
	`CustomerTypeNo`	INT	NOT NULL PRIMARY KEY,
	`CustomerTypeName`	varchar(4)	NOT NULL
);

-- 개인고객상태
DROP TABLE IF EXISTS `CustomerStatus`;

CREATE TABLE `CustomerStatus` (
	`CustomerStatusId`	int	NOT NULL PRIMARY KEY,
	`StatusName`	varchar(10)	NOT NULL
);

-- 소셜 분류
DROP TABLE IF EXISTS `SocialType`;

CREATE TABLE `SocialType` (
	`SocialTypeNo`	INT	NOT NULL PRIMARY KEY,
	`SocialTypeName`	varchar(10)	NOT NULL
);

-- 개인고객분류
DROP TABLE IF EXISTS `PersonalCustomerType`;

CREATE TABLE `PersonalCustomerType` (
	`PersonalCustomerTypeID`	INT	NOT NULL PRIMARY KEY,
	`PersonalCustomerTypeName`	varchar(4)	NOT NULL
);


-- 발권상태
DROP TABLE IF EXISTS `TicketingStatus`;

CREATE TABLE `TicketingStatus` (
	`TicketingStatusID`	int	NOT NULL PRIMARY KEY,
	`TicketingStatusName`	varchar(10)	NOT NULL
);

-- 결제수단
DROP TABLE IF EXISTS `PaymentType`;

CREATE TABLE `PaymentType` (
	`PaymentTypeID`	int	NOT NULL PRIMARY KEY,
	`PaymentTypeName`	varchar(10)	NOT NULL
);

-- 쿠폰타입
DROP TABLE IF EXISTS `CouponType`;

CREATE TABLE `CouponType` (
	`CouponTypeID`	int	NOT NULL PRIMARY KEY,
	`CouponTypeName`	varchar(10)	NOT NULL
);

-- 제휴상품분류
DROP TABLE IF EXISTS `PartnerProductType`;

CREATE TABLE `PartnerProductType` (
	`PartnerProductTypeID`	INT	NOT NULL PRIMARY KEY,
	`PartnerProductTypeName`	varchar(10)	NOT NULL
);

-- 액세서리 분류
DROP TABLE IF EXISTS `AccType`;

CREATE TABLE `AccType` (
	`AccTypeId`	int	NOT NULL PRIMARY KEY,
	`AccName`	varchar(20)	NOT NULL
);

-- 부가서비스분류
DROP TABLE IF EXISTS `ExtraServiceType`;

CREATE TABLE `ExtraServiceType` (
	`ExtraServiceTypeID`	INT	NOT NULL PRIMARY KEY,
	`ExtraServiceTypeName`	varchar(10)	NOT NULL
);

-- 상품분류
DROP TABLE IF EXISTS `ProductType`;

CREATE TABLE `ProductType` (
	`ProductTypeId`	int	NOT NULL PRIMARY KEY,
	`ProductTypeName`	varchar(20)	NOT NULL
);

-- atc advisory
DROP TABLE IF EXISTS `ATC Advisory`;

CREATE TABLE `ATC Advisory` (
	`FlightStatus`	int	NOT NULL PRIMARY KEY,
	`FlightStatusName`	varchar(30)	NOT NULL
);

-- 시즌
DROP TABLE IF EXISTS `Season`;

CREATE TABLE `Season` (
	`SeasonId`	int	NOT NULL PRIMARY KEY,
	`SeasonName`	varchar(20)	NOT NULL
);

-- 항공사
 DROP TABLE IF EXISTS `Airline`;

CREATE TABLE `Airline` (
	`AirlineId`	int	NOT NULL PRIMARY KEY,
	`AirlineName`	varchar(50)	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

-- 항공기
DROP TABLE IF EXISTS `Aircraft`;

CREATE TABLE `Aircraft` (
	`AircraftNo`	int	NOT NULL PRIMARY KEY,
	`KindOfAircraft`	varchar(50)	NOT NULL,
	`AirlineId`	int	NOT NULL
);

-- 상품
DROP TABLE IF EXISTS `Product`;

CREATE TABLE `Product` (
	`ProductId`	int	NOT NULL PRIMARY KEY auto_increment,
	`ProductTypeId`	int	NOT NULL,
	`ProductSoldStatus`	varchar(20)	NOT NULL
);

-- 제휴상품
DROP TABLE IF EXISTS `PartnerProduct`;

CREATE TABLE `PartnerProduct` (
	`ProductId`	int	NOT NULL,
	`PartnerProductName`	varchar(10)	NOT NULL,
	`Description`	varchar(200)	NULL,
	`StartDate`	date	NOT NULL,
	`EndDate`	date	NULL,
	`PartnerProductTypeID`	INT	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

-- 액세서리
DROP TABLE IF EXISTS `Acc`;

CREATE TABLE `Acc` (
	`AccId`	int	NOT NULL,
	`AccTypeId`	int	NOT NULL,
	`Price`	int	NOT NULL
);

-- 결합상품
DROP TABLE IF EXISTS `Package`;

CREATE TABLE `Package` (
	`ProductId`	int	NOT NULL,
	`PackageName`	varchar(20)	NOT NULL
);


-- 결합상품구성상세
DROP TABLE IF EXISTS `PackageDetails`;

CREATE TABLE `PackageDetails` (
	`ProductId`	int	NOT NULL,
	`ProductId2`	int	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

-- 국가
DROP TABLE IF EXISTS `Country`;

CREATE TABLE `Country` (
	`CountryId`	int	NOT NULL PRIMARY KEY,
	`CountryName`	varchar(50)	NOT NULL unique
);

-- 공항
DROP TABLE IF EXISTS `Airport`;

CREATE TABLE `Airport` (
	`AirportId`	int	NOT NULL PRIMARY KEY auto_increment,
	`AirportName`	varchar(50)	NOT NULL,
	`CountryId`	int	NOT NULL
);

-- 운항경로
DROP TABLE IF EXISTS `FlightWay`;

CREATE TABLE `FlightWay` (
	`FlightWayId`	int	NOT NULL PRIMARY KEY auto_increment,
	`Departure`	int	NOT NULL,
	`Arrival`	int	NOT NULL
);


-- 운항계획
DROP TABLE IF EXISTS `FlightPlan`;

CREATE TABLE `FlightPlan` (
	`FlightPlanNo`	int	NOT NULL	PRIMARY KEY auto_increment,
	`AircraftNo`	int	NOT NULL,
	`FlightWayId`	int	NOT NULL,
	`SeasonId`	int	NOT NULL,
	`Price`	int	NOT NULL,
	`FlightDate`	Datetime	NOT NULL,
	`SalesStartDate`	Datetime	NOT NULL
);

-- 항공권
DROP TABLE IF EXISTS `FlightTicket`;

CREATE TABLE `FlightTicket` (
	`FlightId`	int	NOT NULL,
	`FlightPlanNo`	int	NOT NULL,
	`FlightStatus`	int	NOT NULL,
	`Price`	int	NOT NULL
);

-- 승무원
DROP TABLE IF EXISTS `Crew`;

CREATE TABLE `Crew` (
	`CrewId`	int	NOT NULL PRIMARY KEY auto_increment,
	`AirlineId`	int	NOT NULL,
	`Name`	varchar(50)	NOT NULL
);

-- 고객
DROP TABLE IF EXISTS `Customer`;
CREATE TABLE `Customer` (
	`CustomerID`	INT	NOT NULL	PRIMARY KEY auto_increment,
	`CustomerTypeNo`	INT	NOT NULL
);

-- 개인고객
DROP TABLE IF EXISTS `PersonalCustomer`;

CREATE TABLE `PersonalCustomer` (
	`PersonalCustomerID`	INT	NOT NULL,
	`KorName`	varchar(30)	NOT NULL,
	`EngName`	varchar(30)	NOT NULL,
	`Email`	varchar(30)	NOT NULL	 UNIQUE,
	`PhoneNumber`	INT(15)	NOT NULL	 UNIQUE,
	`ID`	varchar(30)	NOT NULL	 UNIQUE,
	`Password`	varchar(20)	NOT NULL,
	`Point`	INT	NOT NULL	DEFAULT 0,
	`PersonalCustomerTypeID`	INT	NOT NULL,
	`CustomerStatusId`	int	NOT NULL
);

-- 법인고객
DROP TABLE IF EXISTS `CorporateCustomer`;

CREATE TABLE `CorporateCustomer` (
	`CorporateCustomerID`	INT	NOT NULL ,
	`RepresentativeName_kor`	varchar(20)	NULL,
	`RepresentativeName_eng`	varchar(20)	NOT NULL,
	`CompanyName`	varchar(20)	NOT NULL,
	`BusinessRegistrationNo`	varchar(30)	NOT NULL UNIQUE,
	`CompanyAddress`	varchar(30)	NULL,
	`CompanyEmail`	varchar(30)	NOT NULL,
	`Active`	varchar(1)	NOT NULL	DEFAULT  'Y'
);

-- 법인우대혜택
DROP TABLE IF EXISTS `CorporateBenefit`;

CREATE TABLE `CorporateBenefit` (
	`CorporateCustomerID`	INT	NOT NULL,
	`PriorityBoarding`	varchar(1)	NOT NULL	DEFAULT 'N',
	`SeatUpgrade`	varchar(1)	NOT NULL	DEFAULT 'N',
	`ExtraBaggageAllowance`	INT	NOT NULL	DEFAULT 0,
	`LoungeAccess`	varchar(1)	NOT NULL	DEFAULT 'N',
	`PreferredSeating`	varchar(1)	NOT NULL	DEFAULT 'N'
);

-- 법인고객직원
DROP TABLE IF EXISTS `CorporateCrew`;

CREATE TABLE `CorporateCrew` (
	`PersonalCustomerID`	INT	NOT NULL,
	`CorporateCustomerID`	INT	NOT NULL
);

-- 고객소셜정보
DROP TABLE IF EXISTS `CustomerSocialDetails`;

CREATE TABLE `CustomerSocialDetails` (
	`CustomerID`	INT	NOT NULL,
	`SocialTypeNo`	INT	NOT NULL,
	`SocialID`	varchar(30)	NOT NULL,
	`SocailPassword`	varchar(30)	NOT NULL
);


-- 항공권예약정보
DROP TABLE IF EXISTS `PNR`;

CREATE TABLE `PNR` (
	`PNRId`	int	NOT NULL	PRIMARY KEY auto_increment,
	`CustomerID`	INT	NOT NULL
);

-- 탑승객
DROP TABLE IF EXISTS `PAX`;

CREATE TABLE `PAX` (
	`PassengerId`	int	NOT NULL PRIMARY KEY auto_increment,
	`PNRId`	int	NOT NULL,
	`Name`	varchar(20)	NOT NULL,
	`Age`	int	NOT NULL,
	`PhoneNumber`	int	NOT NULL
);

-- 여행일정
DROP TABLE IF EXISTS `SEG`;

CREATE TABLE `SEG` (
	`SEGId`	int	NOT NULL	PRIMARY KEY auto_increment,
	`PNRId`	int	NOT NULL,
	`FlightId`	int	NOT NULL
);

-- 특별서비스요청
DROP TABLE IF EXISTS `SSR`;

CREATE TABLE `SSR` (
	`PassengerId`	int	NOT NULL,
	`ResquestMessage`	varchar(100)	NOT NULL,
	`SEGId`	int	NOT NULL
);

-- 부가서비스
DROP TABLE IF EXISTS `ExtraService`;

CREATE TABLE `ExtraService` (
	`ProductId`	int	NOT NULL,
	`AirportId`	int	NOT NULL,
	`ExtraServiceTypeID`	INT	NOT NULL,
	`ExtraServiceName_kor`	varchar(20)	NULL,
	`ExtraServiceName_eng`	varchar(20)	NOT NULL,
	`Price_dollar`	INT	NOT NULL
);

-- 부가서비스예약내역
DROP TABLE IF EXISTS `ExtraServiceReservation`;

CREATE TABLE `ExtraServiceReservation` (
	`ESRId`	int	NOT NULL	PRIMARY KEY auto_increment,
	`PassengerId`	int	NOT NULL,
	`ProductId`	int	NOT NULL,
	`SEGId`	int	NOT NULL
);

-- 선호비행정보	
DROP TABLE IF EXISTS `FlightPreferences`;

CREATE TABLE `FlightPreferences` (
	`CustomerID`	INT	NOT NULL,
	`PreferredSeatType`	varchar(10)	NULL,
	`PreferredSeat`	varchar(10)	NULL,
	`PreferredDepartureAirportID`	int	NOT NULL,
	`PreferredArrivalAirportID`	int	NOT NULL,
	`PreferredProductId`	int	NOT NULL
);

-- 승무원 비행계획
DROP TABLE IF EXISTS `CrewFlightPlan`;

CREATE TABLE `CrewFlightPlan` (
	`FlightPlanNo`	int	NOT NULL,
	`CrewId` int NOT NULL
);

 
/*
DROP TABLE IF EXISTS `CrewTeam`;

CREATE TABLE `CrewTeam` (
	`CrewTeamId`	int	NOT NULL,
	`EmployeeId2`	int	NOT NULL
);
*/

-- 티켓

DROP TABLE IF EXISTS `Ticket`;

CREATE TABLE `Ticket` (
	`TicketID`	int	NOT NULL	PRIMARY KEY auto_increment,
	`PassengerId`	int	NOT NULL,
	`TicketingStatusID`	int	NOT NULL
);
-- 쿠폰
DROP TABLE IF EXISTS `Coupon`;

CREATE TABLE `Coupon` (
	`CouponID`	int	NOT NULL	PRIMARY KEY auto_increment,
	`CouponName`	varchar(20)	NOT NULL,
	`CouponTypeID`	int	NOT NULL,
	`DiscountProductId`	int	NOT NULL,
	`Discount`	int	NOT NULL,
	`VaildFrom`	date	NOT NULL,
	`VaildTo`	date	NOT NULL
);

-- 결제
DROP TABLE IF EXISTS `Payment`;

CREATE TABLE `Payment` (
	`PaymentID`	int	NOT NULL	PRIMARY KEY auto_increment,
	`Fare`	int	NOT NULL,
	`Tax`	int	NOT NULL,
	`CouponID`	int	NOT NULL,
	`TicketID`	int	NOT NULL,
	`PaymentTypeID`	int	NOT NULL
);

-- 환불
DROP TABLE IF EXISTS `Refund`;

CREATE TABLE `Refund` (
	`PaymentID`	int	NOT NULL,
	`RefundTypeID`	int	NOT NULL,
	`Fare`	int	NOT NULL,
	`Tax`	int	NOT NULL
);





ALTER TABLE Customer ADD CONSTRAINT FK_CustomerType_TO_Customer_1 FOREIGN KEY (
	CustomerTypeNo
)
REFERENCES CustomerType (
	CustomerTypeNo
);

ALTER TABLE CorporateCustomer ADD CONSTRAINT FK_Customer_TO_CorporateCustomer_1 FOREIGN KEY (
	CorporateCustomerID
)
REFERENCES Customer (
	CustomerID
);

ALTER TABLE PersonalCustomer ADD CONSTRAINT FK_Customer_TO_PersonalCustomer_1 FOREIGN KEY (
	PersonalCustomerID
)
REFERENCES Customer (
	CustomerID
);

ALTER TABLE PersonalCustomer ADD CONSTRAINT FK_PersonalCustomerType_TO_PersonalCustomer_1 FOREIGN KEY (
	PersonalCustomerTypeID
)
REFERENCES PersonalCustomerType (
	PersonalCustomerTypeID
);

ALTER TABLE PersonalCustomer ADD CONSTRAINT FK_CustomerStatus_TO_PersonalCustomer_1 FOREIGN KEY (
	CustomerStatusId
)
REFERENCES CustomerStatus (
	CustomerStatusId
);

ALTER TABLE Product ADD CONSTRAINT FK_ProductType_TO_Product_1 FOREIGN KEY (
	ProductTypeId
)
REFERENCES ProductType (
	ProductTypeId
);

ALTER TABLE FlightPlan ADD CONSTRAINT FK_Aircraft_TO_FlightPlan_1 FOREIGN KEY (
	AircraftNo
)
REFERENCES Aircraft (
	AircraftNo
);

ALTER TABLE FlightPlan ADD CONSTRAINT FK_FlightWay_TO_FlightPlan_1 FOREIGN KEY (
	FlightWayId
)
REFERENCES FlightWay (
	FlightWayId
);

ALTER TABLE FlightPlan ADD CONSTRAINT FK_Season_TO_FlightPlan_1 FOREIGN KEY (
	SeasonId
)
REFERENCES Season (
	SeasonId
);

ALTER TABLE Aircraft ADD CONSTRAINT FK_Airline_TO_Aircraft_1 FOREIGN KEY (
	AirlineId
)
REFERENCES Airline (
	AirlineId
);

ALTER TABLE Airport ADD CONSTRAINT FK_Country_TO_Airport_1 FOREIGN KEY (
	CountryId
)
REFERENCES Country (
	CountryId
);

ALTER TABLE Crew ADD CONSTRAINT FK_Airline_TO_Crew_1 FOREIGN KEY (
	AirlineId
)
REFERENCES Airline (
	AirlineId
);

ALTER TABLE CustomerSocialDetails ADD CONSTRAINT FK_PersonalCustomer_TO_CustomerSocialDetails_1 FOREIGN KEY (
	CustomerID
)
REFERENCES PersonalCustomer (
	PersonalCustomerID
);

ALTER TABLE CustomerSocialDetails ADD CONSTRAINT FK_SocialType_TO_CustomerSocialDetails_1 FOREIGN KEY (
	SocialTypeNo
)
REFERENCES SocialType (
	SocialTypeNo
);

ALTER TABLE CorporateCrew ADD CONSTRAINT FK_PersonalCustomer_TO_CorporateCrew_1 FOREIGN KEY (
	PersonalCustomerID
)
REFERENCES PersonalCustomer (
	PersonalCustomerID
);

ALTER TABLE CorporateCrew ADD CONSTRAINT FK_CorporateCustomer_TO_CorporateCrew_1 FOREIGN KEY (
	CorporateCustomerID
)
REFERENCES CorporateCustomer (
	CorporateCustomerID
);

ALTER TABLE CorporateBenefit ADD CONSTRAINT FK_CorporateCustomer_TO_CorporateBenefit_1 FOREIGN KEY (
	CorporateCustomerID
)
REFERENCES CorporateCustomer (
	CorporateCustomerID
);

ALTER TABLE FlightPreferences ADD CONSTRAINT FK_Customer_TO_FlightPreferences_1 FOREIGN KEY (
	CustomerID
)
REFERENCES Customer (
	CustomerID
);

ALTER TABLE FlightPreferences ADD CONSTRAINT FK_Airport_TO_FlightPreferences_1 FOREIGN KEY (
	PreferredDepartureAirportID
)
REFERENCES Airport (
	AirportId
);

ALTER TABLE FlightPreferences ADD CONSTRAINT FK_Airport_TO_FlightPreferences_2 FOREIGN KEY (
	PreferredArrivalAirportID
)
REFERENCES Airport (
	AirportId
);

ALTER TABLE FlightPreferences ADD CONSTRAINT FK_Product_TO_FlightPreferences_1 FOREIGN KEY (
	PreferredProductId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE FlightWay ADD CONSTRAINT FK_Airport_TO_FlightWay_1 FOREIGN KEY (
	Departure
)
REFERENCES Airport (
	AirportId
);

ALTER TABLE FlightWay ADD CONSTRAINT FK_Airport_TO_FlightWay_2 FOREIGN KEY (
	Arrival
)
REFERENCES Airport (
	AirportId
);

ALTER TABLE CrewFlightPlan ADD CONSTRAINT FK_FlightPlan_TO_CrewFlightPlan_1 FOREIGN KEY (
	FlightPlanNo
)
REFERENCES FlightPlan (
	FlightPlanNo
);

ALTER TABLE CrewFlightPlan ADD CONSTRAINT FK_Crew_TO_CrewFlightPlan_1 FOREIGN KEY (
	CrewId
)
REFERENCES Crew (
	CrewId
);

ALTER TABLE FlightTicket ADD CONSTRAINT FK_Product_TO_FlightTicket_1 FOREIGN KEY (
	FlightId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE FlightTicket ADD CONSTRAINT FK_FlightPlan_TO_FlightTicket_1 FOREIGN KEY (
	FlightPlanNo
)
REFERENCES FlightPlan (
	FlightPlanNo
);

ALTER TABLE FlightTicket ADD CONSTRAINT FK_ATC_Advisory_TO_FlightTicket_1 FOREIGN KEY (
	FlightStatus
)
REFERENCES `ATC Advisory` (
	FlightStatus
);

ALTER TABLE ExtraService ADD CONSTRAINT FK_Product_TO_ExtraService_1 FOREIGN KEY (
	ProductId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE ExtraService ADD CONSTRAINT FK_Airport_TO_ExtraService_1 FOREIGN KEY (
	AirportId
)
REFERENCES Airport (
	AirportId
);

ALTER TABLE ExtraService ADD CONSTRAINT FK_ExtraServiceType_TO_ExtraService_1 FOREIGN KEY (
	ExtraServiceTypeID
)
REFERENCES ExtraServiceType (
	ExtraServiceTypeID
);

ALTER TABLE PartnerProduct ADD CONSTRAINT FK_Product_TO_PartnerProduct_1 FOREIGN KEY (
	ProductId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE PartnerProduct ADD CONSTRAINT FK_PartnerProductType_TO_PartnerProduct_1 FOREIGN KEY (
	PartnerProductTypeID
)
REFERENCES PartnerProductType (
	PartnerProductTypeID
);

ALTER TABLE Acc ADD CONSTRAINT FK_Product_TO_Acc_1 FOREIGN KEY (
	AccId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE Acc ADD CONSTRAINT FK_AccType_TO_Acc_1 FOREIGN KEY (
	AccTypeId
)
REFERENCES AccType (
	AccTypeId
);

ALTER TABLE Package ADD CONSTRAINT FK_Product_TO_Package_1 FOREIGN KEY (
	ProductId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE PackageDetails ADD CONSTRAINT FK_Package_TO_PackageDetails_1 FOREIGN KEY (
	ProductId
)
REFERENCES Package (
	ProductId
);

ALTER TABLE PackageDetails ADD CONSTRAINT FK_Product_TO_PackageDetails_1 FOREIGN KEY (
	ProductId2
)
REFERENCES Product (
	ProductId
);

ALTER TABLE Ticket ADD CONSTRAINT FK_PAX_TO_Ticket_1 FOREIGN KEY (
	PassengerId
)
REFERENCES PAX (
	PassengerId
);

ALTER TABLE Ticket ADD CONSTRAINT FK_TicketingStatus_TO_Ticket_1 FOREIGN KEY (
	TicketingStatusID
)
REFERENCES TicketingStatus (
	TicketingStatusID
);

ALTER TABLE Coupon ADD CONSTRAINT FK_CouponType_TO_Coupon_1 FOREIGN KEY (
	CouponTypeID
)
REFERENCES CouponType (
	CouponTypeID
);

ALTER TABLE Coupon ADD CONSTRAINT FK_Product_TO_Coupon_1 FOREIGN KEY (
	DiscountProductId
)
REFERENCES Product (
	ProductId
);

ALTER TABLE PNR ADD CONSTRAINT FK_Customer_TO_PNR_1 FOREIGN KEY (
	CustomerID
)
REFERENCES Customer (
	CustomerID
);

ALTER TABLE PAX ADD CONSTRAINT FK_PNR_TO_PAX_1 FOREIGN KEY (
	PNRId
)
REFERENCES PNR (
	PNRId
);

ALTER TABLE Payment ADD CONSTRAINT FK_Coupon_TO_Payment_1 FOREIGN KEY (
	CouponID
)
REFERENCES Coupon (
	CouponID
);

ALTER TABLE Payment ADD CONSTRAINT FK_Ticket_TO_Payment_1 FOREIGN KEY (
	TicketID
)
REFERENCES Ticket (
	TicketID
);

ALTER TABLE Payment ADD CONSTRAINT FK_PaymentType_TO_Payment_1 FOREIGN KEY (
	PaymentTypeID
)
REFERENCES PaymentType (
	PaymentTypeID
);

ALTER TABLE ExtraServiceReservation ADD CONSTRAINT FK_PAX_TO_ExtraServiceReservation_1 FOREIGN KEY (
	PassengerId
)
REFERENCES PAX (
	PassengerId
);

ALTER TABLE ExtraServiceReservation ADD CONSTRAINT FK_ExtraService_TO_ExtraServiceReservation_1 FOREIGN KEY (
	ProductId
)
REFERENCES ExtraService (
	ProductId
);

ALTER TABLE ExtraServiceReservation ADD CONSTRAINT FK_SEG_TO_ExtraServiceReservation_1 FOREIGN KEY (
	SEGId
)
REFERENCES SEG (
	SEGId
);

ALTER TABLE SSR ADD CONSTRAINT FK_PAX_TO_SSR_1 FOREIGN KEY (
	PassengerId
)
REFERENCES PAX (
	PassengerId
);

ALTER TABLE SSR ADD CONSTRAINT FK_SEG_TO_SSR_1 FOREIGN KEY (
	SEGId
)
REFERENCES SEG (
	SEGId
);

ALTER TABLE SEG ADD CONSTRAINT FK_PNR_TO_SEG_1 FOREIGN KEY (
	PNRId
)
REFERENCES PNR (
	PNRId
);

ALTER TABLE SEG ADD CONSTRAINT FK_FlightTicket_TO_SEG_1 FOREIGN KEY (
	FlightId
)
REFERENCES FlightTicket (
	FlightId
);

ALTER TABLE Refund ADD CONSTRAINT FK_Payment_TO_Refund_1 FOREIGN KEY (
	PaymentID
)
REFERENCES Payment (
	PaymentID
);

ALTER TABLE Refund ADD CONSTRAINT FK_PaymentType_TO_Refund_1 FOREIGN KEY (
	RefundTypeID
)
REFERENCES PaymentType (
	PaymentTypeID
);

