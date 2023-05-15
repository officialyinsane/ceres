use ceres;

create table bodies ( -- TODO: link to Material data from journal/1.json.json.json.json.json.json.json.json.json.json.json.json
    -- TODO: Link to parents from journal/1.json.json.json.json.json.json.json.json.json.json.json.json?
    -- TODO: Link to atmosphereComposition from journal/1.json.json.json.json.json.json.json.json.json.json.json.json when present
    id bigint auto_increment not null primary key,
    systemId bigint not null, -- TODO: FK relationship?
    atmosphereType varchar(50) null,
    axialTilt float null,
    className varchar(50) null, -- TODO: Link to dictionary lookup?
    distanceFromArrival float null,
    eccentricity float null,
    landable bit null,
    name varchar(50) not null,
    `offset` int not null, -- FIXME: comment "BodyID from message",
    massEm float null,
    meanAnomaly float null,
    orbitalInclination bigint null, -- TODO: Scientific?
    orbitalPeriod float null,
    periapsis float null, -- TODO: What is this?
    radius float null,
    rotationPeriod float null,
    semiMajorAxis float null,
    surfaceGravity float null,
    surfacePressure float null,
    surfaceTemperature float null,
    terraformState varchar(50) null, -- TODO: Check datatype from journal/1.json.json.json.json.json.json.json.json.json.json.json.json when not empty string
    tidalLock bit null,
    volcanism varchar(50) null, -- TODO: Check datatype from journal/1.json.json.json.json.json.json.json.json.json.json.json.json when not empty string
    `created` timestamp not null default current_timestamp,
    `updated` timestamp not null default current_timestamp on update current_timestamp
)