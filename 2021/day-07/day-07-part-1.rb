class Day07
  attr_reader :data

    def initialize(input)
      @data = IO.read(input).split(",").map(&:to_i)
    end

    def part1
      least_cost_fuel_position = least_cost_fuel_position(data)
      data.map{|position| (position - least_cost_fuel_position).abs}.sum
    end

    def least_cost_fuel_position(array)
      sorted = array.sort
      mid = (sorted.length - 1) / 2
      (sorted[mid.floor] + sorted[mid.ceil]) / 2
    end
end

p Day07.new("day-07-input.txt").part1