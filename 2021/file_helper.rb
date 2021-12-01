class FileHelper
    def self.parse(input)
        IO.read(input).lines
    end
end