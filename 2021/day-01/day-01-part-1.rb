require "../file_helper.rb"

class Day01Part1
    
    attr_reader :input_contents

    def initialize(input)
        @input_contents = FileHelper.parse(input)
    end

    def part01

        input_contents
            .map(&:to_i)
            .each_cons(2)
            .count { |first, second| 
                first < second 
        }

    end

end

p Day01Part1.new("./day-01-input.txt").part01