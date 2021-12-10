class Day07
  attr_reader :initial_positions

    def initialize(input)
      @initial_positions = IO.read(input).split(",").map(&:to_i)
    end

    def part2

      horizontal_min = initial_positions.min
      horizontal_max = initial_positions.max

      avg_fuel_costs = []

      (horizontal_min..horizontal_max).each {|crab_initial_position|
        avg_fuel_costs  << calculate_cost_of_fuel_for(crab_initial_position, initial_positions)
      }

      avg_fuel_costs.min
    end

    def calculate_cost_of_fuel_for(crab_initial_position, initial_positions)
      initial_positions
        .map{ |crab_actual_position| (crab_actual_position - crab_initial_position).abs }
        .map{ |distance_to_least_cost_point| (1..distance_to_least_cost_point).sum }
        .sum
    end

end

p Day07.new("day-07-input.txt").part2