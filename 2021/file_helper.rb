class FileHelper
    def self.parse(input)
        IO.read(input).lines(chomp: true)
    end
end