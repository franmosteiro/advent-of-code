require "../file_helper.rb"

class Day05
    
    attr_reader :input_line_of_vents

    def initialize(input)
      @input_line_of_vents = FileHelper.parse(input)
    end
		
    def part2
			Matrix
				.new(input_line_of_vents)
				.compute
				.flatten
				.count { |cover_point| 
					!cover_point.nil? && cover_point >= 2 
				}
    end

end

class Matrix
	attr_reader :input_line_of_vents

	def initialize(input_line_of_vents)
		@input_line_of_vents = input_line_of_vents
	end

	def compute
		matrix = []
		input_line_of_vents.each{|raw_line_of_vent|
			line_of_vent = raw_line_of_vent.split('->')
			point_1 = line_of_vent[0].strip.split(',').map(&:to_i)
			point_2 = line_of_vent[1].strip.split(',').map(&:to_i)

			distance_x = point_2[0] - point_1[0]
			distance_y = point_2[1] - point_1[1]

			unit_x = distance_x.zero? ? 0 : distance_x / distance_x.abs
			unit_y = distance_y.zero? ? 0 : distance_y / distance_y.abs

			distance = [distance_x.abs, distance_y.abs].max + 1

			matrix = increment_cover_lines(distance, point_1, unit_x, unit_y, matrix)
		}
		matrix
	end

	private
		def increment_cover_lines(distance, point_1, unit_x, unit_y, matrix)
			distance.times do |i|
				x = point_1[0] + i * unit_x
				y = point_1[1] + i * unit_y
				matrix[x] = [] if matrix[x].nil?
				matrix[x][y] = (matrix[x][y] || 0) + 1
			end
			matrix
		end
end

p Day05.new("day-05-input.txt").part2