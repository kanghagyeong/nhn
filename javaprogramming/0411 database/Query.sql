use Module06;

DELIMITER $$
CREATE PROCEDURE getAircraft
(
	m_aircraftno	int
)
BEGIN
	SELECT *
	FROM aircraft
	WHERE
		AircraftNo = m_aircraftno;
END $$
DELIMITER ;