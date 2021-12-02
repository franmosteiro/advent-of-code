require "../file_helper.rb"

class Day02Part2
    
    attr_reader :input_contents

    def initialize(input)
        @input_contents = FileHelper.parse(input)
    end

    def part02

        horizontal = 0
        depth = 0
        aim = 0

        input_contents
            .map{ |line|
                direction, steps = line.split(" ")

                case direction 
                when "forward"
                    horizontal += steps.to_i
                    if aim > 0
                        depth += steps.to_i * aim
                    end
                when "up"
                    aim -= steps.to_i
                when "down"
                    aim += steps.to_i
                end
            }
            
        horizontal * depth

    end

end

p Day02Part2.new("./day-02-input.txt").part02