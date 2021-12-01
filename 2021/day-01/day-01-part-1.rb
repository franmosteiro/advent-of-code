class Day01Part1
    
    def initialize(input)
        @input_contents = IO.read(input)
    end

    def part01

        @input_contents
            .lines
            .map(&:to_i)
            .each_cons(2)
            .count { |first, second| 
                first < second 
        }

    end

end

p Day01Part1.new("./day-01-input.txt").part01