require "../file_helper.rb"

class Day02Part2
    
    attr_reader :input_contents
    attr_accessor :horizontal, :depth, :aim

    def initialize(input)
        @input_contents = FileHelper.parse(input)
        @horizontal = 0
        @depth = 0
        @aim = 0
    end

    def part02
        input_contents.map{ |direction_line| parse_direction(direction_line)}
        horizontal * depth
    end

    def parse_direction(direction_line)
        direction, steps = direction_line.split(" ")
        case direction 
        when "forward"
            @horizontal += steps.to_i
            if @aim > 0
                @depth += steps.to_i * aim
            end
        when "up"
            @aim -= steps.to_i
        when "down"
            @aim += steps.to_i
        end
    end

end

p Day02Part2.new("./day-02-input.txt").part02