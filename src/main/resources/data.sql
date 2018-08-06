--Cars data 
insert into car values(1);
insert into car values(2);
insert into car values(3);
insert into car values(4);

--Drivers data
insert into driver(id, name, status, car_id) values(1, 'DRIVER 1','AVAILABLE', 1);
insert into driver(id, name, status, car_id) values(2, 'DRIVER 2','AVAILABLE', 2);
insert into driver(id, name, status, car_id) values(3, 'DRIVER 3','AVAILABLE', 3);
insert into driver(id, name, status, car_id) values(4, 'DRIVER 4','AVAILABLE', 4);

--Users  data
insert into user(uuid, name, device_type) values('eec318e6-a286-43d9-a65e-2ca29fc31e59', 'USER 1', 'ANDROID');
insert into user(uuid, name, device_type) values('770cd5b4-effe-423f-b3f4-5663a95d32e1', 'USER 2','ANDROID');
insert into user(uuid, name, device_type) values('4c9863f8-02ab-4d23-af5b-742ce39f0f00', 'USER 3','IOS');
insert into user(uuid, name, device_type) values('ee2bf36e-21bc-4a5d-90e7-3ecbd96bbce2', 'USER 4','IOS');

--Attentions data
insert into attention(status, driver_id, uuid) values('REQUESTED', null, 'eec318e6-a286-43d9-a65e-2ca29fc31e59');
insert into attention(status, driver_id, uuid) values('REQUESTED', null, '770cd5b4-effe-423f-b3f4-5663a95d32e1');
insert into attention(status, driver_id, uuid) values('CANCELLED', null, '4c9863f8-02ab-4d23-af5b-742ce39f0f00');




