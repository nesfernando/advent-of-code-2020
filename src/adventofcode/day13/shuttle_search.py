#!/usr/bin/env python3
time_at_stop = 1015292
bus_ids = [19,41,743,13,17,29,643,37,23]

print("Hello world");

id_to_next_arrival = {}

for bus_id in bus_ids:
  #int(939 / 7) * 7 + 7
  id_to_next_arrival[bus_id] = int(time_at_stop / bus_id) * bus_id + bus_id

print(id_to_next_arrival)

earliest_bus = min(id_to_next_arrival, key=id_to_next_arrival.get)

time_to_wait = id_to_next_arrival[earliest_bus] - time_at_stop

part_one_answer = earliest_bus * time_to_wait

print(part_one_answer)
