select request_at as 'Day',
    Round(
        sum(
            case 
                when t1.client_id not in (select users_id from Users where banned = 'Yes') 
                    and t1.driver_id not in (select users_id from Users where banned = 'Yes')
                    and t1.status != 'completed'
                then 1
                else 0
            end
        )/
        sum(
            case 
                when t1.client_id not in (select users_id from Users where banned = 'Yes') 
                    and t1.driver_id not in (select users_id from Users where banned = 'Yes')
                then 1
                else 0
            end
        ),
        2
    ) as 'Cancellation Rate'
from trips t1
where t1.client_id not in (select users_id from Users where banned = 'Yes') 
    and t1.driver_id not in (select users_id from Users where banned = 'Yes')
    and request_at between "2013-10-01" and "2013-10-03"
group by request_at