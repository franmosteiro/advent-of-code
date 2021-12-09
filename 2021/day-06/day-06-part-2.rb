require "../file_helper.rb"

class Day06
    
    attr_reader :data

    def initialize(input)
      @data = IO.read(input).split(",").map(&:to_i)
    end

    def part2
      grouped_days_of_birth = data.clone.tally

			forecast(256, grouped_days_of_birth)
        .values
        .sum
    end

    def forecast(cycles, grouped_days_of_birth)
      cycles.times do
        next_cycle = Hash.new(0)
        grouped_days_of_birth.each {|days_to_birth, count|
          case days_to_birth
          when 0
            next_cycle[6] += count
            next_cycle[8] += count
          else
            next_cycle[days_to_birth - 1] += count
          end
        }
        grouped_days_of_birth = next_cycle
      end
      grouped_days_of_birth
    end

end

p Day06.new("day-06-input.txt").part2