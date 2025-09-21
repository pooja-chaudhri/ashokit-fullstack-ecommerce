# Stage 1: Build Angular app
FROM node:20 AS build
WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install

# Copy all source files and build Angular app
COPY . .
RUN npm run build --prod

# Stage 2: Serve with Nginx
FROM nginx:alpine

# Copy the built Angular app to Nginx's html folder
COPY --from=build /app/dist/ashokit-e-comm-application /usr/share/nginx/html

# Expose port 80
EXPOSE 80


