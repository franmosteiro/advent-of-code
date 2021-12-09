require "../file_helper.rb"

class Day05
    
    attr_reader :input_file_lines

    def initialize(input)
      @input_file_lines = FileHelper.parse(input)
    end

    def part1
			Matrix.new(input_file_lines).compute
    end

end

class Matrix
	attr_reader :input_file_lines

	def initialize(input_file_lines)
		@input_file_lines = input_file_lines
	end

	def compute
		matrix = []
		input_file_lines.each{|raw_line|
			instruction_line = raw_line.split('->')
			coordinates_1 = instruction_line[0].strip.split(',').map(&:to_i)
			coordinates_2 = instruction_line[1].strip.split(',').map(&:to_i)

			distance_x = coordinates_2[0] - coordinates_1[0]
			distance_y = coordinates_2[1] - coordinates_1[1]

			next unless distance_x.zero? || distance_y.zero?

			unit_x = distance_x.zero? ? 0 : distance_x / distance_x.abs
			unit_y = distance_y.zero? ? 0 : distance_y / distance_y.abs

			distance = [distance_x.abs, distance_y.abs].max + 1

			distance.times do |i|
				x = coordinates_1[0] + i * unit_x
				y = coordinates_1[1] + i * unit_y
				matrix[x] = [] if matrix[x].nil?
				matrix[x][y] = (matrix[x][y] || 0) + 1
			end
		}

		matrix.flatten.count { |cover_point| !cover_point.nil? && cover_point >= 2 }

	end
end

p Day05.new("day-05-input.txt").part1