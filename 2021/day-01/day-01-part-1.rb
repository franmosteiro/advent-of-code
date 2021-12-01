class Day01Part1
    
    def initialize(input)
        @input_contents = IO.read(input)
    end

    def part01
    
        increased = 0

        @input_contents.lines.map(&:to_i).each_cons(2) { |first, second| 
            increased = increased + 1 unless first > second 
        }

        p increased

    end

end

Day01Part1.new("./day-01-input.txt").part01()