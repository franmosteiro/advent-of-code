require "../file_helper.rb"

class Day02Part1
    
    attr_reader :input_contents
    attr_accessor :horizontal, :depth

    def initialize(input)
        @input_contents = FileHelper.parse(input)
        @horizontal = 0
        @depth = 0
    end

    def part01
        input_contents.map{ |direction_line| parse_direction(direction_line)}
        horizontal * depth
    end

    private
    def parse_direction(direction_line)
        direction, steps = direction_line.split(" ")
        case direction 
        when "forward"
            @horizontal += steps.to_i
        when "up"
            @depth -= steps.to_i
        when "down"
            @depth += steps.to_i
        end
    end

end

p Day02Part1.new("./day-02-input.txt").part01