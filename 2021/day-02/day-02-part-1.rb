require "../file_helper.rb"

class Day02Part1
    
    attr_reader :input_contents

    def initialize(input)
        @input_contents = FileHelper.parse(input)
    end

    def part01

        horizontal = 0
        depth = 0

        input_contents
            .map{ |line|
                direction, steps = line.split(" ")

                case direction 
                when "forward"
                    horizontal += steps.to_i
                when "up"
                    depth -= steps.to_i
                when "down"
                    depth += steps.to_i
                end
            }

        horizontal * depth

    end

end

p Day02Part1.new("./day-02-input.txt").part01