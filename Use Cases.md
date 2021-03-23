# USE CASE: 1 Provide the ability to add new customers, and the ability to amend these details

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Internet Usage Department* we want to be able to add new customer records when they join our company, and have the ability to amend these details.

### Scope

Company.

### Level

Primary task.

### Preconditions

New customer is not already on the system. Existing customer details are available for update.

### Success End Condition

Details of new customers are added to the system, and can be updated as and when required.

### Failed End Condition

New customer records cannot be added, or existing customer records cannot be updated.

### Primary Actor

Internet Usage Department.

### Trigger

A new customer joins, or an existing customer's details need updated.

## MAIN SUCCESS SCENARIO

1. Details of new customer are captured.
2. Details of new customer are added to the system.
3. Internet Usage Department can query the system to verify details added.
4. Internet Usage Department can update the customer's details in the system.

## EXTENSIONS

1. System is unavailable.
2. Details of existing system cannot be found.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0


# USE CASE: 2 Provide the ability to report on populations of the world, specific continents, regions, countries, districts and cities.

## CHARACTERISTIC INFORMATION

### Goal in Context


As an *organisation* we want to be able to report on populations, of ether the world or of specific areas of the world.
### Scope

System.

### Level

Primary task.

### Preconditions

SQL database available. Population information system functioning properly.

### Success End Condition

The population information system can query the SQL database and return the required population information.

### Failed End Condition

No population information is returned.

### Primary Actor

Organisation staff.

### Trigger

Requirement for population information on the world or a specific subset.

## MAIN SUCCESS SCENARIO

1. Details of population information required are defined.
2. Population information system is started.
3. Connection to SQL database is tested and confirmed to be correct.
4. Population information system returns information required.

## EXTENSIONS

1. Population information system is unavailable.
2. Connection to SQL database is not possible.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 2.0